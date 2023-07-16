# Test Kampus Merdeka Suitmedia
This application is a simple Android app consisting of three screens: First Screen, Second Screen, and Third Screen. It allows users to check if a sentence is a palindrome, display user information from an API, and interact with user data.

## First Screen
The First Screen of the app features two input fields and two buttons:

* One input field for entering a name.
* Another input field for entering a sentence to check if it's a palindrome.
* A "Check" button to initiate the palindrome check.
* A "Next" button to navigate to the Second Screen.

When the "Check" button is clicked, a dialog will be shown with a message indicating whether the entered sentence is a palindrome or not.
And when the "Next" button is clicked, it will navigate to the Second Screen with saving the Username input.

## Second Screen
The Second Screen is a static screen that displays the following elements:

* A "Welcome" text label.
* Two dynamic labels: one to display the name entered on the First Screen and another to show the selected user's name.
* A button labeled "Choose a User" to navigate to the Third Screen.

## Third Screen
The Third Screen includes a list or table view of users obtained from the "regres.in" API. Each user entry in the list displays information such as email, first name, last name, and avatar.

* Pull-to-refresh functionality to refresh the user list.
* Infinite scrolling, where the next page of data is loaded automatically when scrolling to the bottom of the list.
* An empty state is shown if there is no user data available.
* When a user item is clicked in the list, the selected user's name is displayed on the Second Screen without creating a new screen.

The application makes use of various Android components and libraries to implement these features, such as EditText, TextView, buttons, RecyclerView, SwipeRefreshLayout, and API integration using Retrofit and Gson.


## Screenshots

| First Screen | First Screen - Check Palindrome |
|--------------|--------------------------------|
| <img src="https://github.com/rfttra/Test_Suitmedia/assets/99707014/59f09f18-50d1-498c-9583-24837dfdc071" width="300"> | <img src="https://github.com/rfttra/Test_Suitmedia/assets/99707014/a9ac9fa6-f449-4837-9ab4-e93def3522b4" width="300"> |

| Second Screen | Third Screen |
|---------------|--------------|
| <img src="https://github.com/rfttra/Test_Suitmedia/assets/99707014/515ef493-4ed6-48b9-b177-dc03767c8c2c" width="300"> | <img src="https://github.com/rfttra/Test_Suitmedia/assets/99707014/90911d17-26a2-45d1-95d4-53f198c0b6bf" width="300"> |

| Second Screen - User Clicked |
|------------------------------|
| <img src="https://github.com/rfttra/Test_Suitmedia/assets/99707014/f27194f7-c6bd-477d-92ba-1727bcb520ed" width="300"> |


