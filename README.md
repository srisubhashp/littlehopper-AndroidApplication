# CSE 3310 - Group 1 README



## Building the app

- The apk of the app can be executed by following the below path :

        `\Teaching-Todlers-App\app\build\outputs\apk\debug`
    
- The project can also be run by opening Android Studio, and pressing the play button in the top-right corner

- Emulator or device must be running Android 4.4 (KitKat) or above

## Register / Login

- The user will be greeted upon by a registration page, where the app will verify to make sure he enters the correct email and such that the password requirements are met.

- Then the user is directed to the main page, where we can see all the respective buttons of the levels, profile page and level statistics.



## Game Levels

One the homepage, the user can select from three different game levels
 - Level 1 : Identifying colors
 - Level 2 : Simple Arithmetic 
 - Level 3 : Identifying objects and animals
 
 Each level contains 15 different multiple choice questions, in which user is given instant feedback on whether the user entered the right/wrong answer.

The score is displayed after completing the level, showing how many questions they got right, and it is updated on the Level Statistics page in real time using Firebase.
 
 

## Profile Page 
One the homepage, the user can also navigate to the profile page or the level statistics page.

On the Profile Page, the user will be able to view

- First Name
- Last Name
- Age
- Phone Number
- Email Address

The user's name and email address is entered during the registration process, while the age and phone number can be added within the app.

The user also has the option to log out of the app on this page.


## Level Statistics

The level statistics page will display the most recent score and the number of attemps for

- Level 1
- Level 2
- Level 3

The data for the number of attempts and the most recent score is stored using Firebase.



