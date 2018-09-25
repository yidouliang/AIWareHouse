package com.boot.security.server.controller;

import com.boot.security.server.utils.ConstUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created By Seven.wk
 * Description: 工具类控制器，对外提供工具类服务
 * Created At 2018/09/25
 */
@RestController
@RequestMapping("/util")
public class UtilController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    /**
     * 产生验证码
     * @param response
     * @param session
     * @throws IOException
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletResponse response,
                        HttpSession session) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        String captchaCode = defaultKaptcha.createText();
        session.setAttribute(ConstUtil.CAPTCHA_CODE, captchaCode);
        BufferedImage challenge = defaultKaptcha.createImage(captchaCode);
        ImageIO.write(challenge, "jpg", jpegOutputStream);

        //生成图片
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

}
