package com.boot.security.server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.boot.security.server.config.StaticConfig;
import com.boot.security.server.dao.ExecProductDao;
import com.boot.security.server.model.ExecProduct;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.utils.AESUtils;
import com.boot.security.server.utils.MD5;
import com.boot.security.server.utils.MyHttpUrlConnection;
import com.boot.security.server.utils.UserUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/outInterface")
public class OutInterface {

    @Autowired
    private ExecProductDao execProductDao;

    @Autowired
    private StaticConfig staticConfig;

    @GetMapping("/getuser")
    public SysUser currentUser() {


        return UserUtil.getLoginUser();
    }


    @RequestMapping("getWXtelphone")
    public void getWXtelphone(HttpServletRequest request, HttpServletResponse response)throws Exception{
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"utf-8");
        BufferedReader buffer=new BufferedReader(reader);
        String dataIn=buffer.readLine();
        JSONObject paramIn =   JSONObject.parseObject(dataIn);
        JSONObject obj = new JSONObject();
        String result ="";

        String MD5Key = staticConfig.md5key;//秘钥MD5key---联调时联系联调人员获取

        if(null!=(paramIn))
        {

            String encryptedData =  paramIn .get("encryptedData").toString();
            String openId =  paramIn .get("openId").toString();
            String iv =  paramIn .get("iv").toString();
            String session_key =  paramIn .get("session_key").toString();
            String appidS = "wx3a7342fdaa22d4ef";
            String back =  decryptData(encryptedData,iv,session_key,appidS);


           // result = obj.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue);
            writeToResponse(response, back);
            return;
        }


        obj.put("status", "1001");
        obj.put("message", "人参不能为空");

        result = obj.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue);

        writeToResponse(response, result);
        return;
    }



    @RequestMapping("getWXTokenBycode")
    public void getWXTokenBycode(HttpServletRequest request, HttpServletResponse response)throws Exception{
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"utf-8");
        BufferedReader buffer=new BufferedReader(reader);
        String dataIn=buffer.readLine();
        JSONObject paramIn =   JSONObject.parseObject(dataIn);
        JSONObject obj = new JSONObject();
        String result ="";

        String MD5Key = staticConfig.md5key;//秘钥MD5key---联调时联系联调人员获取

        if(null!=(paramIn))
        {

            String jsCode =  paramIn .get("jscode").toString();
            String appidS = "wx3a7342fdaa22d4ef";
            String secretS = "c135270cb291009e6b9f8d888a9d2af9";
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+ appidS+"&secret="+ secretS +"&js_code="
                + jsCode + "&grant_type=authorization_code";
            String res[] = MyHttpUrlConnection.requestJson(url);
            System.out.println(res[0]);
            JSONObject object = JSON.parseObject(res[0]);
            String openId = object.getString("openid");
            String session_key = object.getString("session_key");


            obj.put("openId", openId);
            obj.put("status", "0");
            obj.put("session_key", session_key);

            result = obj.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue);
            writeToResponse(response, result);
            return;
        }


        obj.put("status", "1001");
        obj.put("message", "人参不能为空");

        result = obj.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue);

        writeToResponse(response, result);
        return;
    }


    @RequestMapping("getProductByCode")
    public void getProductByCode(HttpServletRequest request, HttpServletResponse response)throws Exception{
        InputStreamReader reader=new InputStreamReader(request.getInputStream(),"utf-8");
        BufferedReader buffer=new BufferedReader(reader);
        String dataIn=buffer.readLine();
        JSONObject paramIn =   JSONObject.parseObject(dataIn);
        JSONObject obj = new JSONObject();
        String result ="";

        String MD5Key = staticConfig.md5key;//秘钥MD5key---联调时联系联调人员获取

        if(null!=(paramIn))
        {

           String code =  paramIn .get("productCode").toString();

           String signKey =  paramIn.get("sign").toString();
            String sign = MD5.sign(code, MD5Key, "UTF-8");
            if(!signKey.equals(sign)){
                obj.put("status", "-999");
                obj.put("message", "签名不对");
                result = obj.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue);
                writeToResponse(response, result);
                return;
            }
            List arrPro = new ArrayList();
            String [] arr = code.split(",");
            if(arr.length>0){
                for (int i = 0;i<arr.length;i++){
                    if(null!=arr[i]&&!arr[i].equals("")){
                        ExecProduct productC =  execProductDao.getByCode(arr[i]);
                        arrPro.add(productC);

                    }

                }



            }

            obj.put("products", arrPro);
            obj.put("status", "0");
            obj.put("message", "sucess");

            result = obj.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue);
            writeToResponse(response, result);
            return;
            //传 一个 产品code过来，查询出产品信息，及是否已经被售卖；
        }


        obj.put("status", "1001");
        obj.put("message", "人参不能为空");

        result = obj.toJSONString(obj, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue);

        writeToResponse(response, result);
        return;
    }
    protected void writeToResponse(final HttpServletResponse response, final String result) throws Exception {
        response.setHeader("Content-type", "text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(result);
        response.getWriter().flush();
        response.getWriter().close();
    }


    /**
     * 检验数据的真实性，并且获取解密后的明文.
     * @param encryptedData string 加密的用户数据
     * @param iv string 与用户数据一同返回的初始向量
     *
     * @return data string 解密后的原文
     */
    public String decryptData(String encryptedData, String iv,String sessionKey,String appid)
    {

        if (StringUtils.length(sessionKey) != 24)
        {
            return "ErrorCode::$IllegalAesKey;";
        }
        // 对称解密秘钥 aeskey = Base64_Decode(session_key), aeskey 是16字节。
        byte[] aesKey = Base64.decodeBase64(sessionKey);

        if (StringUtils.length(iv) != 24)
        {
            return "ErrorCode::$IllegalIv;";
        }
        // 对称解密算法初始向量 为Base64_Decode(iv)，其中iv由数据接口返回。
        byte[] aesIV = Base64.decodeBase64(iv);

        // 对称解密的目标密文为 Base64_Decode(encryptedData)
        byte[] aesCipher = Base64.decodeBase64(encryptedData);

        Map<String, String> map = new HashMap<>();

        try
        {
            byte[] resultByte = AESUtils.decrypt(aesCipher, aesKey, aesIV);

            if (null != resultByte && resultByte.length > 0)
            {
                String userInfo = new String(resultByte, "UTF-8");
                map.put("code", "0000");
                map.put("msg", "succeed");
                map.put("userInfo", userInfo);

                // watermark参数说明：
                // 参数  类型  说明
                // watermark   OBJECT  数据水印
                // appid   String  敏感数据归属appid，开发者可校验此参数与自身appid是否一致
                // timestamp   DateInt 敏感数据获取的时间戳, 开发者可以用于数据时效性校验'

                // 根据微信建议：敏感数据归属appid，开发者可校验此参数与自身appid是否一致
                // if decrypted['watermark']['appid'] != self.appId:
                JSONObject jsons = JSON.parseObject(userInfo);
                String id = jsons.getJSONObject("watermark").getString("appid");
                if(!StringUtils.equals(id, appid))
                {
                    return "ErrorCode::$IllegalBuffer;";
                }
            }
            else
            {
                map.put("status", "1000");
                map.put("msg", "false");
            }
        }
        catch (InvalidAlgorithmParameterException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }


    }
