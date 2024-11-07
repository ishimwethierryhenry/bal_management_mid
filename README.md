This is the Mid Term Project of WebTechnology and Internet

My project is all about Basketball Africa League

Developer Info

Name: ISHIMWE Thierry Henry

ID: 25319

Group: E


                                                                                BAL Management System
                                                                                
                                                                                   Project Overview
                                                                                   
The BAL Management System is a web application developed to streamline user management for the Basketball Africa League. Built with Spring Boot, this system offers robust user account management, role-based access control, and enhanced features for admins and users to manage accounts effectively. It includes user authentication, secure password recovery, profile management, and data visualization, with a focus on scalability and modern user experience.

Features

User Account Management
![image](https://github.com/user-attachments/assets/bcbf8022-44f6-4c81-83cd-bb439d861121)



Login & Signup: Users can register and log in securely.

![image](https://github.com/user-attachments/assets/0784839d-fb8f-4051-9593-77fbb3602fe4)
![image](https://github.com/user-attachments/assets/244f31b8-6625-4896-be17-e963055ebf69)
![image](https://github.com/user-attachments/assets/5dea6797-53c3-4878-902a-a3423ea4623e)

After logging in,...


![image](https://github.com/user-attachments/assets/eaf95dae-0d42-44de-be3f-0d69869e6cd6)

He can update his info...
![image](https://github.com/user-attachments/assets/76284d27-15fb-4eb0-a9b2-ac03a44a17d1)
![image](https://github.com/user-attachments/assets/a6f7a722-f238-4049-9983-d5911c83b632)


Forgot Password: Users who forgot their passwords can reset them using a reset link sent to their email, powered by javax.mail API integration.


![image](https://github.com/user-attachments/assets/d1961cb0-6d84-457b-b3ec-815dd29b7c79)

Now,a reset link valid for 15 minutes is sent to the user's email...

![image](https://github.com/user-attachments/assets/11dc7349-2e17-4e32-a9b5-ed9a70cadf78)

Let,s go and find the link...

![image](https://github.com/user-attachments/assets/89015500-d00f-421d-8ae4-2375e09a12ca)

We can go to the link...and as you can see there are some important data validations as far as password matching criteria is concerned...

![image](https://github.com/user-attachments/assets/b2deb866-ed4d-4c0b-963e-e9a00d296fe4)





Admin Tools


Audit Trail: Tracks actions performed by admins, such as creating or deleting a user.

Lemme try to delete the recently registered jeanluc user...

But,before look what I had in the initial Audit Trail table...[After you'll notice the change after deleting the guy]...

![image](https://github.com/user-attachments/assets/776469de-347b-4b6d-be75-786eb7be8e58)



Now,lemme delete him...

![image](https://github.com/user-attachments/assets/0817142c-81b5-4f85-80c4-5255016c5078)
![image](https://github.com/user-attachments/assets/e8e6750c-defe-4f18-8ecc-37ef0ea7e6d9)

....he's now deleted....Now,let's go and inspect the audit trail infos...

![image](https://github.com/user-attachments/assets/1ae2e804-cd5a-4d01-ac9d-2c98baa449c4)

You can now see that the first row of the audit trail table shows that the guy jeanluc was deleted most recently and the time stamp is recorded and retrieved successfully!

This is the same when a user is updated,or created...and even logs in.






Role-Based Access Control (RBAC): Implemented using Spring Security for restricting features based on user roles.

Lemme try to login as admin....

![image](https://github.com/user-attachments/assets/f7a3451b-9598-4b40-ad0a-07d5e79c3ca0)
![image](https://github.com/user-attachments/assets/aca29369-8b8d-4670-a66c-125f8d2ba20c)


Session Management: Ensures secure session handling and user activity monitoring.[A user tried to access a URL once his not logged in,and a miracle happened below]

![image](https://github.com/user-attachments/assets/f1d72666-fbcf-42be-961b-f3ddc9ff7e04)


Enhanced User Experience


Notifications: Admins can send announcements and notifications, which users can read in their respective portals.

Lemme try to notify users on the upcoming match event...

![image](https://github.com/user-attachments/assets/aef9e0e0-4132-4157-98ae-fddb0bc28bb0)

![image](https://github.com/user-attachments/assets/73258345-d5fa-4cef-b9bc-a0739c7a931c)


Now,let me login as a standard user to see if He can receive the notification
![image](https://github.com/user-attachments/assets/117e3934-611e-44f2-97f9-b0a02a703d23)

Now on,a user can read the notification and mark as read...

![image](https://github.com/user-attachments/assets/55e09811-da81-4e3a-8c3b-4bf6909a88e3)



Search, Sort, and Filter: Users can search, sort, and filter by role, email, and username, providing easy access to specific records.

![image](https://github.com/user-attachments/assets/87c7a67b-7e7e-45d1-8348-27ccfbe0096a)
![image](https://github.com/user-attachments/assets/1ad0e9c8-af49-4b82-80d0-93054e924339)
![image](https://github.com/user-attachments/assets/99d7e22a-1f5d-4ce4-8f7f-d1078c973b5b)
![image](https://github.com/user-attachments/assets/669fd0e2-905a-4c71-82df-6da85ebc86ae)
![image](https://github.com/user-attachments/assets/51501583-666d-43fe-8879-af836007f7bc)
![image](https://github.com/user-attachments/assets/c4349296-1b9d-4ff2-b46f-69a23e210290)
![image](https://github.com/user-attachments/assets/1399676a-dbc7-4133-b03c-c005fa2ed34a)
![image](https://github.com/user-attachments/assets/ff664011-9b00-4d8a-8436-7477f9ce2c04)
![image](https://github.com/user-attachments/assets/30487ff7-0e1c-4f20-9348-41a28b3167c6)
![image](https://github.com/user-attachments/assets/7a8176f8-f76c-411a-8822-c61fe87d3515)
![image](https://github.com/user-attachments/assets/847b41f4-5b9d-454a-bf2c-88e17cf22f06)
![image](https://github.com/user-attachments/assets/3344730e-d958-4011-b338-0ce29efa9ac5)




Pagination: Limited to three items per page to enhance performance and usability.

![image](https://github.com/user-attachments/assets/7b57ffea-60d1-4622-9943-b92561f81e25)
![image](https://github.com/user-attachments/assets/5e3bef3e-bb89-4046-bdd5-044858bcf8d5)
![image](https://github.com/user-attachments/assets/1a8235db-8183-47a7-b3fb-1b54af6e7872)





File and Data Management

Profile Picture Upload: Users can upload and update their profile pictures.

![image](https://github.com/user-attachments/assets/e2d14e54-5a33-4e8d-89d0-95b4e419cfb2)
![image](https://github.com/user-attachments/assets/98067487-2a7f-4ad4-a7d9-517a53cc934f)
![image](https://github.com/user-attachments/assets/7487dab4-74c6-49a4-b250-2648444477fa)
![image](https://github.com/user-attachments/assets/02c42e08-3241-48be-b897-848d901d4fe5)

...And after that the Profile picture is updated a user can go back to the portal,and finds the image updated successfully!!!!!!!!!

![image](https://github.com/user-attachments/assets/6193f49d-2b71-4da2-afae-445755db03ea)





Data Export: Allows downloading the user list in multiple formats - PDF, CSV, and XLS for easy record keeping.

![image](https://github.com/user-attachments/assets/c1c7bb49-3cd7-42a8-9527-902fb3086ae0)
![image](https://github.com/user-attachments/assets/083913d5-d954-4700-bf78-cc9f2ccb384f)
![image](https://github.com/user-attachments/assets/c1a5d30d-138f-45c5-9715-deacf2c70e86)
![image](https://github.com/user-attachments/assets/1e4194a8-fcaf-4e80-8374-15e786f09553)
![image](https://github.com/user-attachments/assets/3dc1d8ba-b482-4b7c-a35b-4e30370e682f)



Data Visualization and Reporting

Charts and Graphs: Includes interactive data visualizations using JavaScript animations and React, showing user statistics and role distributions for insightful analysis.

![image](https://github.com/user-attachments/assets/105c069d-faa7-442e-8960-524038257059)
![image](https://github.com/user-attachments/assets/7526f123-cbd9-4702-9d51-376a8bd40a57)
![image](https://github.com/user-attachments/assets/a71f165b-468b-4c8e-8f0b-4a5bf4affa11)





API Integrations

Email API: javax.mail API used for Forgot Password functionality, enhancing account security and recovery options.

Multi-Language Support: Utilizes I18n to offer a multilingual experience, making the app accessible to users worldwide.

...Let's do the multi language...

By default,on my Landing page,I have a way to change the language to any of which I want by the moment...

So,I have an English language by default as it's the one that my system uses...

![image](https://github.com/user-attachments/assets/e63d3be1-4e21-4a48-9895-fa00890e57f4)

Now,lemme change it to french

![image](https://github.com/user-attachments/assets/71900df1-8dc9-4b2e-94fa-202c63f0c2b9)
![image](https://github.com/user-attachments/assets/0362b670-7d77-4c5a-a929-34edbd987dfb)

Even in kinyarwanda...

![image](https://github.com/user-attachments/assets/77b36af7-266f-41bf-9f1b-c0f5c1597f60)

...Kizulu...

![image](https://github.com/user-attachments/assets/12e263b3-75f3-4a7c-9287-0228a92f0eb6)

...German...

![image](https://github.com/user-attachments/assets/3b1f6c2e-01c8-43dc-97da-a5df75a926e0)

...Aymara....

![image](https://github.com/user-attachments/assets/d5b072a5-b7f1-4ad2-b58a-e2db82d7ba12)

Or any other language of your choice....









Technical Specifications

Framework: Spring Boot, Spring Security
Database: MySQL
Front-end: Thymeleaf CSS,Js, React for animations and data visualization
Pagination Limit: 3 items per page
Export Formats: PDF, CSV, XLS
Notification System: Real-time notifications for users



If you want to watch a video through the project,below are the Links to the videos on google drive:

https://drive.google.com/file/d/1HR6eO7bOLR3UyBa-gBPnWFLgvYT4BXPL/view?usp=drive_link
https://drive.google.com/file/d/1uVYQJ0mWSZdMf7d67s1CysIW88iKPUUK/view?usp=drive_link
https://drive.google.com/file/d/1KoZX2HXZtOlfBxB9eVFe3czk8IT2dKIf/view?usp=drive_link

Don't Forget to support me in any affordable way...
More to come!!!
See you.....
