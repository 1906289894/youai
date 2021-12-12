**开发遇到问题及解决方案**


1-------2021/12/12  21:31:23.204:   git-push 代码提交问题
 
[youai] git -c credential.helper= -c core.quotepath=false -c log.showSignature=false push --progress --porcelain origin refs/heads/dev_0.5v:dev_0.5v
ERROR: Permission to 1906289894/youai.git denied to kangkang-web.
fatal: Could not read from remote repository.
Please make sure you have the correct access rights
and the repository exists.~~~~

解决方法:  1.重新配置-gitshh秘钥2.查看是否有提交代码权限.
