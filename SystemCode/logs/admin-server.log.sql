2018-09-26 09:13:07,050 [http-nio-9090-exec-1] ==>  Preparing: select * from sys_user t where t.username = ? 
2018-09-26 09:13:07,068 [http-nio-9090-exec-1] ==> Parameters: admin(String)
2018-09-26 09:13:07,224 [http-nio-9090-exec-1] <==      Total: 1
2018-09-26 09:13:07,240 [http-nio-9090-exec-1] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2018-09-26 09:13:07,264 [http-nio-9090-exec-1] ==> Parameters: 1(Long)
2018-09-26 09:13:07,327 [http-nio-9090-exec-1] <==      Total: 45
2018-09-26 09:13:07,686 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2018-09-26 09:13:07,707 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2018-09-26 09:13:07,813 [taskExecutor-1] <==    Updates: 1
2018-09-26 09:13:09,371 [http-nio-9090-exec-3] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2018-09-26 09:13:09,376 [http-nio-9090-exec-3] ==> Parameters: 1(Long)
2018-09-26 09:13:09,419 [http-nio-9090-exec-3] <==      Total: 1
2018-09-26 09:13:12,760 [http-nio-9090-exec-9] ==>  Preparing: select count(1) from ai_exec_product t 
2018-09-26 09:13:12,762 [http-nio-9090-exec-9] ==> Parameters: 
2018-09-26 09:13:12,803 [http-nio-9090-exec-9] <==      Total: 1
2018-09-26 09:13:12,808 [http-nio-9090-exec-9] ==>  Preparing: select * from ai_exec_product t order by id asc limit ?, ? 
2018-09-26 09:13:12,813 [http-nio-9090-exec-9] ==> Parameters: 0(Integer), 10(Integer)
2018-09-26 09:13:12,859 [http-nio-9090-exec-9] <==      Total: 1
2018-09-26 09:13:18,012 [http-nio-9090-exec-2] ==>  Preparing: select * from ai_exec_product t where t.id = ? 
2018-09-26 09:13:18,014 [http-nio-9090-exec-2] ==> Parameters: 1(Long)
2018-09-26 09:13:18,059 [http-nio-9090-exec-2] <==      Total: 1
2018-09-26 09:13:22,807 [http-nio-9090-exec-1] ==>  Preparing: update ai_exec_product t SET productcode = ?, aicode = ?, productname = ?, productdesc = ?, producttypeid = ?, productoriprice = ?, productstatus = ?, productpicpath = ?, producturl = ?, creator = ?, createdate = ?, modifydate = ?, datastate = ?, productsource = ?, ext1 = ?, ext2 = ?, ext3 = ? where t.id = ? 
2018-09-26 09:13:22,810 [http-nio-9090-exec-1] ==> Parameters: 2(String), 20(String), 2(String), 2(String), 2(Integer), 2(BigDecimal), 2(Integer), 2(String), 2(String), 2(BigDecimal), 2018-09-03 23:45:27.0(Timestamp), 2018-09-26 23:45:32.0(Timestamp), 2(Integer), 2(String), 2(Integer), 2(String), 2(String), 1(Long)
2018-09-26 09:13:22,901 [http-nio-9090-exec-1] <==    Updates: 1
2018-09-26 09:13:24,387 [http-nio-9090-exec-1] ==>  Preparing: select count(1) from ai_exec_product t 
2018-09-26 09:13:24,390 [http-nio-9090-exec-1] ==> Parameters: 
2018-09-26 09:13:24,428 [http-nio-9090-exec-1] <==      Total: 1
2018-09-26 09:13:24,430 [http-nio-9090-exec-1] ==>  Preparing: select * from ai_exec_product t order by id asc limit ?, ? 
2018-09-26 09:13:24,431 [http-nio-9090-exec-1] ==> Parameters: 0(Integer), 10(Integer)
2018-09-26 09:13:24,472 [http-nio-9090-exec-1] <==      Total: 1
2018-09-26 09:24:17,928 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2018-09-26 09:24:17,954 [taskExecutor-1] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2018-09-26 09:24:18,089 [taskExecutor-1] <==    Updates: 1
2018-09-26 09:35:37,353 [http-nio-9090-exec-10] ==>  Preparing: select * from sys_user t where t.username = ? 
2018-09-26 09:35:37,363 [http-nio-9090-exec-10] ==> Parameters: dfgd(String)
2018-09-26 09:35:37,463 [http-nio-9090-exec-10] <==      Total: 0
2018-09-26 09:35:43,773 [http-nio-9090-exec-8] ==>  Preparing: select * from sys_user t where t.username = ? 
2018-09-26 09:35:43,774 [http-nio-9090-exec-8] ==> Parameters: admin(String)
2018-09-26 09:35:43,911 [http-nio-9090-exec-8] <==      Total: 1
2018-09-26 09:35:43,925 [http-nio-9090-exec-8] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2018-09-26 09:35:43,927 [http-nio-9090-exec-8] ==> Parameters: 1(Long)
2018-09-26 09:35:44,000 [http-nio-9090-exec-8] <==      Total: 45
2018-09-26 09:35:54,073 [http-nio-9090-exec-1] ==>  Preparing: select * from sys_user t where t.username = ? 
2018-09-26 09:35:54,073 [http-nio-9090-exec-1] ==> Parameters: admin(String)
2018-09-26 09:35:54,135 [http-nio-9090-exec-1] <==      Total: 1
2018-09-26 09:35:54,136 [http-nio-9090-exec-1] ==>  Preparing: select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permissionId inner join sys_role_user ru on ru.roleId = rp.roleId where ru.userId = ? order by p.sort 
2018-09-26 09:35:54,137 [http-nio-9090-exec-1] ==> Parameters: 1(Long)
2018-09-26 09:35:54,188 [http-nio-9090-exec-1] <==      Total: 45
2018-09-26 09:35:54,348 [taskExecutor-1] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2018-09-26 09:35:54,361 [taskExecutor-1] ==> Parameters: 1(Long), 登陆(String), true(Boolean), null
2018-09-26 09:35:54,485 [taskExecutor-1] <==    Updates: 1
2018-09-26 09:35:54,853 [http-nio-9090-exec-6] ==>  Preparing: select count(1) from t_notice t left join t_notice_read r on r.noticeId = t.id and r.userId = ? where t.status = 1 and r.userId is null 
2018-09-26 09:35:54,858 [http-nio-9090-exec-6] ==> Parameters: 1(Long)
2018-09-26 09:35:54,908 [http-nio-9090-exec-6] <==      Total: 1
2018-09-26 09:35:57,545 [taskExecutor-2] ==>  Preparing: insert into sys_logs(userId, module, flag, remark, createTime) values(?, ?, ?, ?, now()) 
2018-09-26 09:35:57,546 [taskExecutor-2] ==> Parameters: 1(Long), 退出(String), true(Boolean), null
2018-09-26 09:35:57,637 [taskExecutor-2] <==    Updates: 1
