Demonstrate The usage of SpringBoot with Security JWT (JSON Web Token)

	com.distareza.springsecurityjwt.config.SecurityConfig
	com.distareza.springsecurityjwt.filter.JwtFilter

1. 	authenticate service API : http://localhost:9192/authenticate , to generate the Token
	post with body json payload { userName : [...] , password : [...] }
	
2.	To access the service API : http://localhost:9192 , http://localhost:992/info 
	you required to pass header with generate token above
	header : { "Authorization" : "Bearer [token]" }
	

 	 