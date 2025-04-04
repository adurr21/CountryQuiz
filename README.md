<div id="top">

<!-- HEADER STYLE: CLASSIC -->
<div align="center">

# COUNTRYQUIZ

<!-- BADGES -->
<img src="https://img.shields.io/github/license/adurr21/CountryQuiz?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
<img src="https://img.shields.io/github/last-commit/adurr21/CountryQuiz?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
<img src="https://img.shields.io/github/languages/top/adurr21/CountryQuiz?style=default&color=0080ff" alt="repo-top-language">
<img src="https://img.shields.io/github/languages/count/adurr21/CountryQuiz?style=default&color=0080ff" alt="repo-language-count">

<!-- default option, no dependency badges. -->


<!-- default option, no dependency badges. -->

</div>
<br>

---

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
    - [Project Index](#project-index)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Usage](#usage)
    - [Testing](#testing)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

---

## Overview

CountryQuiz is a simple app that allows people to test their knowledge on countries and their locations on the globe.

---

## Features

| Component | Details                              |
| :-------- | :----------------------------------- |
| **Architecture** | * Monolithic architecture with multiple modules (e.g., `app/build.gradle`, `fragment_quiz.xml`) |
| **Code Quality** | * Adheres to standard Java coding conventions and best practices (e.g., `java` files, `strings.xml`) |
| **Documentation** | * Limited documentation, mostly in the form of XML comments (e.g., `data_extraction_rules.xml`, `fragment_splash_screen.xml`) |
| **Integrations** | * Integrates with various Android components and libraries (e.g., `ic_launcher.xml`, `fragment_past_quizzes_list.xml`) |
| **Modularity** | * Modular design, but not strictly adhering to the Model-View-Controller (MVC) pattern |
| **Testing** | * Limited testing framework usage, mostly relying on Gradle's built-in testing features |
| **Performance** | * Optimized for performance using Android's native rendering and caching mechanisms |
| **Security** | * Basic security measures implemented, such as input validation and sanitization (e.g., `fragment_quiz_question.xml`) |
| **Dependencies** | * Manages dependencies through Gradle's build system, with a focus on version management (e.g., `libs.versions.toml`) |
| **Scalability** | * Designed to scale horizontally using Android's native support for multiple screens and devices |

---

## Project Structure

```sh
└── CountryQuiz/
    ├── app
    │   ├── .gitignore
    │   ├── build.gradle
    │   ├── proguard-rules.pro
    │   └── src
    ├── build.gradle
    ├── gradle
    │   ├── libs.versions.toml
    │   └── wrapper
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle
```

### Project Index

<details open>
	<summary><b><code>COUNTRYQUIZ/</code></b></summary>
	<!-- __root__ Submodule -->
	<details>
		<summary><b>__root__</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ __root__</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/build.gradle'>build.gradle</a></b></td>
					<td style='padding: 8px;'>- Architects the Projects Build Configuration**Configures the projects build settings, ensuring a solid foundation for the entire codebase architecture<br>- Establishes dependencies and plugins to facilitate efficient compilation and deployment of the application<br>- Sets the stage for successful integration of various components, enabling seamless development and testing processes.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'>- Starts a Gradle build process on Windows, setting up the environment for compiling and packaging the projects dependencies<br>- It resolves Java installation issues, sets default JVM options, and executes the Gradle wrapper script to run the build process<br>- The script also handles errors and provides an exit code for the build process.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/settings.gradle'>settings.gradle</a></b></td>
					<td style='padding: 8px;'>- Configures Project Repositories**The settings.gradle file configures the projects repository management, specifying Google, Maven Central, and Gradle Plugin Portal as sources for dependencies<br>- It sets up a dependency resolution strategy that prioritizes project repositories over external ones, ensuring seamless integration with the CountryQuiz app<br>- This configuration enables efficient access to libraries and plugins required by the project.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- app Submodule -->
	<details>
		<summary><b>app</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ app</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/proguard-rules.pro'>proguard-rules.pro</a></b></td>
					<td style='padding: 8px;'>- Enforces ProGuard Rules**The <code>app/proguard-rules.pro</code> file configures ProGuard rules to optimize the Android projects codebase<br>- It controls the set of applied configuration files and specifies custom rules for the project, including preserving line number information for debugging stack traces<br>- By applying these rules, the project achieves improved code compression and reduced APK size.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/build.gradle'>build.gradle</a></b></td>
					<td style='padding: 8px;'>- Architects the Android application framework for the country quiz project, defining the build configuration, namespace, and dependencies<br>- Establishes the minimum and target SDK versions, version codes, and compatibility levels<br>- Configures the build types, compile options, and features to enable view binding and support for various libraries, ensuring a solid foundation for the apps development and testing phases.</td>
				</tr>
			</table>
			<!-- src Submodule -->
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ app.src</b></code>
					<!-- main Submodule -->
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ app.src.main</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/AndroidManifest.xml'>AndroidManifest.xml</a></b></td>
									<td style='padding: 8px;'>- Launches the Country Quiz application, configuring Android settings such as icon, theme, and data extraction rules<br>- Defines the main activity as the apps entry point, allowing users to interact with the quiz<br>- Ensures compatibility with various Android versions and RTL support<br>- Provides a foundation for the apps functionality, enabling users to access the quiz experience.</td>
								</tr>
							</table>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ app.src.main.java</b></code>
									<!-- edu Submodule -->
									<details>
										<summary><b>edu</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.java.edu</b></code>
											<!-- uga Submodule -->
											<details>
												<summary><b>uga</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ app.src.main.java.edu.uga</b></code>
													<!-- countryquiz Submodule -->
													<details>
														<summary><b>countryquiz</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ app.src.main.java.edu.uga.countryquiz</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/MainActivity.java'>MainActivity.java</a></b></td>
																	<td style='padding: 8px;'>- The main purpose of the <code>MainActivity</code> class is to manage the applications state and display different fragments based on user interactions<br>- It retrieves records from a database, displays past quizzes, and starts new quizzes<br>- The class handles activity lifecycle events such as pause, resume, and stop, ensuring data consistency and app stability.</td>
																</tr>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/AsyncTask.java'>AsyncTask.java</a></b></td>
																	<td style='padding: 8px;'>The AsyncTask class provides an alternative implementation of Androids built-in AsyncTask class, allowing for concurrent execution of background tasks while maintaining UI thread safety.**Key FunctionalityIt enables developers to execute long-running operations in the background without blocking the main UI thread, ensuring a responsive user experience.</td>
																</tr>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/DatabaseHelper.java'>DatabaseHelper.java</a></b></td>
																	<td style='padding: 8px;'>- The provided Java class <code>DatabaseHelper</code> appears to be a SQLite database helper class that provides methods for interacting with the database<br>- The class includes methods for retrieving random country entries, storing quiz results, and retrieving past quizzes<br>- However, there are some potential issues with the code, such as missing imports and unused variables.</td>
																</tr>
															</table>
															<!-- fragments Submodule -->
															<details>
																<summary><b>fragments</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.edu.uga.countryquiz.fragments</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/fragments/QuizFragment.java'>QuizFragment.java</a></b></td>
																			<td style='padding: 8px;'>- Manages a quiz with multiple questions displayed in a ViewPager2, handling user answers and transitioning to results upon completion<br>- The fragment initializes the Quiz object and user answers list from arguments, restoring saved answers and position if provided<br>- It sets up the ViewPager2 with a QuizPagerAdapter and handles page changes, ultimately displaying quiz results when all questions are completed.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/fragments/MyQuizzesRecyclerViewAdapter.java'>MyQuizzesRecyclerViewAdapter.java</a></b></td>
																			<td style='padding: 8px;'>- Displays a list of past quizzes in a RecyclerView, showcasing quiz date and score percentage<br>- It constructs an adapter with a list of Quiz objects to be displayed, inflates the layout for each item, binds data to views, and returns the total number of quizzes<br>- The adapter is designed to efficiently manage and display quiz information, providing a user-friendly interface for viewing past quizzes.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/fragments/QuizResultsFragment.java'>QuizResultsFragment.java</a></b></td>
																			<td style='padding: 8px;'>- Achieves displaying quiz results, calculating scores, and saving them to a database<br>- The fragment updates the UI with the users score and date of completion, allowing users to view past quizzes, return to the splash screen, or start a new quiz<br>- It also integrates with a database helper class to store and retrieve quiz results.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/fragments/PastQuizzesFragment.java'>PastQuizzesFragment.java</a></b></td>
																			<td style='padding: 8px;'>- Displays a list of past quizzes in a RecyclerView, providing buttons to return to the home screen or start a new quiz<br>- Retrieves column count from arguments and configures button click listeners accordingly<br>- Utilizes a custom adapter to display the list of past quizzes, allowing users to navigate between different quiz options<br>- Facilitates easy navigation within the apps main menu.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/fragments/QuizQuestionFragment.java'>QuizQuestionFragment.java</a></b></td>
																			<td style='padding: 8px;'>- Displays a users answer to a quiz question**The QuizQuestionFragment displays a users answer to a specific question from the provided quiz<br>- It loads the current question and its choices, allowing users to select an answer from three options<br>- The selected answer is stored in the user's answers list for later reference.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/fragments/SplashScreen.java'>SplashScreen.java</a></b></td>
																			<td style='padding: 8px;'>- Start Quiz and View Results<br>- Upon button click, navigates to the corresponding activity, allowing users to begin a new quiz or view past results<br>- The fragment serves as an introductory interface before transitioning to the main application functionality.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- content Submodule -->
															<details>
																<summary><b>content</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.edu.uga.countryquiz.content</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/content/QuizQuestion.java'>QuizQuestion.java</a></b></td>
																			<td style='padding: 8px;'>- Generates unique quiz questions about countries and their continents by retrieving data from a database and creating two incorrect options<br>- The <code>QuizQuestion</code> class constructs new instances with country names, correct continents, and randomly selected wrong continent options to create engaging quizzes<br>- It relies on the <code>MainActivity.dbHelper</code> for accessing the database, ensuring accurate and diverse question content.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/content/Quizzes.java'>Quizzes.java</a></b></td>
																			<td style='padding: 8px;'>- Manages a collection of Quiz objects, providing access to past quizzes stored in the applications database<br>- Retrieves and updates the list of past quizzes from the database via MainActivitys database helper, serving as a utility for retrieving quiz data<br>- Facilitates interaction with the quiz data, enabling the application to display past quizzes to users.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/java/edu/uga/countryquiz/content/Quiz.java'>Quiz.java</a></b></td>
																			<td style='padding: 8px;'>One for creating a new quiz with predefined questions and another for loading past quizzes from a database.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
							<!-- res Submodule -->
							<details>
								<summary><b>res</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ app.src.main.res</b></code>
									<!-- drawable Submodule -->
									<details>
										<summary><b>drawable</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.res.drawable</b></code>
											<table style='width: 100%; border-collapse: collapse;'>
											<thead>
												<tr style='background-color: #f8f9fa;'>
													<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
													<th style='text-align: left; padding: 8px;'>Summary</th>
												</tr>
											</thead>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/drawable/ic_launcher_foreground.xml'>ic_launcher_foreground.xml</a></b></td>
													<td style='padding: 8px;'>- Launch Icon Design AchievedThe provided XML file defines the visual design of the apps launch icon, creating a distinctive and recognizable logo<br>- The vector graphics element is used to create a dynamic and scalable image that can be displayed on various Android devices<br>- The resulting icon effectively represents the brand identity of the application.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/drawable/ic_launcher_background.xml'>ic_launcher_background.xml</a></b></td>
													<td style='padding: 8px;'>- Launches the applications icon on various Android devices<br>- The provided XML file defines a vector graphic that serves as the launcher background image<br>- It consists of multiple paths that create a distinctive design, with subtle stroke lines and solid colors<br>- This graphic is used to represent the apps identity across different screen sizes and resolutions.</td>
												</tr>
											</table>
										</blockquote>
									</details>
									<!-- layout Submodule -->
									<details>
										<summary><b>layout</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.res.layout</b></code>
											<table style='width: 100%; border-collapse: collapse;'>
											<thead>
												<tr style='background-color: #f8f9fa;'>
													<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
													<th style='text-align: left; padding: 8px;'>Summary</th>
												</tr>
											</thead>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/layout/fragment_past_quizzes.xml'>fragment_past_quizzes.xml</a></b></td>
													<td style='padding: 8px;'>- Generate Fragment Layout**The provided XML file defines the layout structure for a fragment displaying past quizzes<br>- It consists of two horizontal linear layouts containing item numbers and quiz content, respectively<br>- The layout is designed to be flexible and adaptable to different screen sizes<br>- This file plays a crucial role in rendering the user interface for the apps quiz feature.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/layout/fragment_quiz_results.xml'>fragment_quiz_results.xml</a></b></td>
													<td style='padding: 8px;'>- Displays the quiz results, including score and date, in a visually appealing layout with buttons to navigate back to home, view past quizzes, or start a new quiz<br>- The design utilizes Androids ConstraintLayout to efficiently arrange UI elements, ensuring a seamless user experience<br>- The layout adapts to various screen sizes while maintaining its core functionality.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/layout/fragment_splash_screen.xml'>fragment_splash_screen.xml</a></b></td>
													<td style='padding: 8px;'>- Launches the splash screen layout, providing a welcome message and instructions on how to interact with the app<br>- The layout includes two buttons to start a new quiz or view past quizzes, along with a description of the quiz experience<br>- It serves as the initial user interface before transitioning to other screens in the app.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/layout/fragment_quiz.xml'>fragment_quiz.xml</a></b></td>
													<td style='padding: 8px;'>- Architects the layout for a quiz fragment, defining a FrameLayout with a ViewPager2 as its child<br>- The layout serves as the foundation for a quiz interface, enabling users to navigate through multiple questions or screens<br>- It provides a basic structure for displaying content and handling user interactions within the app.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/layout/activity_main.xml'>activity_main.xml</a></b></td>
													<td style='padding: 8px;'>- Launches the main activity of the application, setting up a frame layout to hold the fragment container view<br>- The SplashScreen fragment is initialized and displayed within this container, serving as the initial entry point for the app<br>- This file plays a crucial role in establishing the foundation of the user interface, enabling the apps primary functionality to commence.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/layout/fragment_past_quizzes_list.xml'>fragment_past_quizzes_list.xml</a></b></td>
													<td style='padding: 8px;'>- Generates Layout for Past Quizzes List Fragment**The provided XML file generates the layout for a fragment that displays a list of past quizzes<br>- It includes buttons to return home and start a new quiz, as well as text views to display the date and score<br>- The layout is designed to be adaptable and user-friendly, with a focus on showcasing the list of past quizzes.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/layout/fragment_quiz_question.xml'>fragment_quiz_question.xml</a></b></td>
													<td style='padding: 8px;'>- Generates Quiz Question Layout**The provided XML file generates a layout for a quiz question fragment, displaying the question text and three radio button options for user selection<br>- The layout is designed to be responsive and adaptable to different screen sizes, with a focus on clear typography and intuitive user interaction<br>- It serves as a fundamental building block for the overall quiz application architecture.</td>
												</tr>
											</table>
										</blockquote>
									</details>
									<!-- values-night Submodule -->
									<details>
										<summary><b>values-night</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.res.values-night</b></code>
											<table style='width: 100%; border-collapse: collapse;'>
											<thead>
												<tr style='background-color: #f8f9fa;'>
													<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
													<th style='text-align: left; padding: 8px;'>Summary</th>
												</tr>
											</thead>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/values-night/themes.xml'>themes.xml</a></b></td>
													<td style='padding: 8px;'>- Establishes Dark Theme Configuration**Configures the dark theme settings for the application, defining a custom base theme called Base.Theme.CountryQuiz"<br>- This setting inherits from the Material3 DayNight NoActionBar theme and allows for customization of color schemes<br>- The configuration enables developers to tailor the app's visual appearance to suit their preferences, ensuring a consistent user experience across various devices and screen orientations.</td>
												</tr>
											</table>
										</blockquote>
									</details>
									<!-- values Submodule -->
									<details>
										<summary><b>values</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.res.values</b></code>
											<table style='width: 100%; border-collapse: collapse;'>
											<thead>
												<tr style='background-color: #f8f9fa;'>
													<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
													<th style='text-align: left; padding: 8px;'>Summary</th>
												</tr>
											</thead>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/values/colors.xml'>colors.xml</a></b></td>
													<td style='padding: 8px;'>- Black and white<br>- These colors are used throughout the app to maintain a consistent visual identity, ensuring a cohesive user experience<br>- The defined colors enable easy modification of the color palette in the future, allowing for seamless updates across the entire project.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/values/dimens.xml'>dimens.xml</a></b></td>
													<td style='padding: 8px;'>- Defines Resource Dimensions**Establishes the text margin dimension value of 16dp in the projects resource values file, influencing layout and typography throughout the application<br>- This configuration enables consistent spacing and visual hierarchy across UI elements, contributing to a cohesive user experience<br>- The updated dimensions are made available for use in subsequent development stages.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/values/themes.xml'>themes.xml</a></b></td>
													<td style='padding: 8px;'>- Define Application Theme**Establishes the base application theme for CountryQuiz, a mobile app<br>- The <code>Base.Theme.CountryQuiz</code> style inherits from Material3s DayNight NoActionBar theme and allows customization of the light theme<br>- A secondary theme, <code>Theme.CountryQuiz</code>, is defined as an extension of the base theme, providing a cohesive visual identity for the app.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/values/strings.xml'>strings.xml</a></b></td>
													<td style='padding: 8px;'>- Architects the Projects Core Identity**Establishes the projects core identity by defining essential strings that power the application's user interface and experience<br>- Sets the foundation for a cohesive brand voice, ensuring consistency across the app's various components<br>- Provides a crucial link between the project's overall vision and its individual elements, ultimately contributing to a polished and engaging user experience.</td>
												</tr>
											</table>
										</blockquote>
									</details>
									<!-- xml Submodule -->
									<details>
										<summary><b>xml</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.res.xml</b></code>
											<table style='width: 100%; border-collapse: collapse;'>
											<thead>
												<tr style='background-color: #f8f9fa;'>
													<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
													<th style='text-align: left; padding: 8px;'>Summary</th>
												</tr>
											</thead>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/xml/backup_rules.xml'>backup_rules.xml</a></b></td>
													<td style='padding: 8px;'>- Backup Rules Configuration**Configures the backup rules for Android devices, specifying which data to back up and under what conditions<br>- This file is used by the Android system to determine which data to include in a full backup<br>- It provides a sample configuration that can be customized as needed to meet specific requirements.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/xml/data_extraction_rules.xml'>data_extraction_rules.xml</a></b></td>
													<td style='padding: 8px;'>- Extracts data extraction rules for cloud backup functionality, defining what data is included or excluded from backups<br>- This file serves as a configuration point for the projects backup behavior, allowing developers to customize and control what data is backed up<br>- It provides a centralized location for managing backup settings, ensuring consistency across the application.</td>
												</tr>
											</table>
										</blockquote>
									</details>
									<!-- mipmap-anydpi-v26 Submodule -->
									<details>
										<summary><b>mipmap-anydpi-v26</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.res.mipmap-anydpi-v26</b></code>
											<table style='width: 100%; border-collapse: collapse;'>
											<thead>
												<tr style='background-color: #f8f9fa;'>
													<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
													<th style='text-align: left; padding: 8px;'>Summary</th>
												</tr>
											</thead>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/mipmap-anydpi-v26/ic_launcher.xml'>ic_launcher.xml</a></b></td>
													<td style='padding: 8px;'>- Launches the adaptive icon for the Android application, ensuring compatibility with various screen densities and colors<br>- The XML file defines the icons background, foreground, and monochrome variants, allowing for seamless integration across different devices and platforms<br>- It plays a crucial role in maintaining a consistent user experience throughout the app.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml'>ic_launcher_round.xml</a></b></td>
													<td style='padding: 8px;'>- Launches the adaptive icon for the Android application, ensuring compatibility across various screen densities and devices<br>- The XML file defines the visual appearance of the icon, including its background, foreground, and monochrome variants, which are used to display the apps logo on different platforms<br>- It enables a seamless user experience across various devices and screen sizes.</td>
												</tr>
											</table>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<!-- test Submodule -->
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ app.src.test</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ app.src.test.java</b></code>
									<!-- edu Submodule -->
									<details>
										<summary><b>edu</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.test.java.edu</b></code>
											<!-- uga Submodule -->
											<details>
												<summary><b>uga</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ app.src.test.java.edu.uga</b></code>
													<!-- countryquiz Submodule -->
													<details>
														<summary><b>countryquiz</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ app.src.test.java.edu.uga.countryquiz</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/test/java/edu/uga/countryquiz/ExampleUnitTest.java'>ExampleUnitTest.java</a></b></td>
																	<td style='padding: 8px;'>- Unit Test Framework Integration**The <code>ExampleUnitTest.java</code> file serves as a foundation for the projects unit testing framework integration<br>- It provides a basic example of a JUnit test case, demonstrating how to write and execute assertions to validate expected results<br>- This code enables the development team to ensure their application's functionality is thoroughly tested, ensuring reliability and accuracy in the country quiz game.</td>
																</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<!-- androidTest Submodule -->
					<details>
						<summary><b>androidTest</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ app.src.androidTest</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ app.src.androidTest.java</b></code>
									<!-- edu Submodule -->
									<details>
										<summary><b>edu</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.androidTest.java.edu</b></code>
											<!-- uga Submodule -->
											<details>
												<summary><b>uga</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ app.src.androidTest.java.edu.uga</b></code>
													<!-- countryquiz Submodule -->
													<details>
														<summary><b>countryquiz</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ app.src.androidTest.java.edu.uga.countryquiz</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/app/src/androidTest/java/edu/uga/countryquiz/ExampleInstrumentedTest.java'>ExampleInstrumentedTest.java</a></b></td>
																	<td style='padding: 8px;'>- Verifies App Context IntegrityThe <code>ExampleInstrumentedTest</code> class ensures the apps context is correctly set up and verified on an Android device<br>- It checks if the app's package name matches the expected value, providing a basic level of assurance that the app's configuration is intact<br>- This test serves as a foundational component for ensuring the overall integrity of the country quiz application.</td>
																</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<!-- gradle Submodule -->
	<details>
		<summary><b>gradle</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ gradle</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/adurr21/CountryQuiz/blob/master/gradle/libs.versions.toml'>libs.versions.toml</a></b></td>
					<td style='padding: 8px;'>- Configures Project Dependencies**The <code>gradle/libs.versions.toml</code> file configures the projects dependencies, specifying versions for various libraries and frameworks used in the codebase<br>- It ensures consistency across the project by defining standard versions for Android components such as JUnit, Espresso, Material Design, and RecyclerView<br>- This configuration enables seamless integration of these libraries into the project architecture.</td>
				</tr>
			</table>
		</blockquote>
	</details>
</details>

---

## Getting Started

This project requires the following dependencies:

- **Programming Language:** Java
- **Package Manager:** Gradle

---

## Contributing

- **💬 [Join the Discussions](https://github.com/adurr21/CountryQuiz/discussions)**: Share your insights, provide feedback, or ask questions.
- **🐛 [Report Issues](https://github.com/adurr21/CountryQuiz/issues)**: Submit bugs found or log feature requests for the `CountryQuiz` project.
- **💡 [Submit Pull Requests](https://github.com/adurr21/CountryQuiz/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/adurr21/CountryQuiz
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/adurr21/CountryQuiz/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=adurr21/CountryQuiz">
   </a>
</p>
</details>

---

## Acknowledgments

- Austin Durr
- Jacob Sehl

<div align="right">

[![][back-to-top]](#top)

</div>


[back-to-top]: https://img.shields.io/badge/-BACK_TO_TOP-151515?style=flat-square


---
