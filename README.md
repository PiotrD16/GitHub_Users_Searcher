# GitHub User Searcher (Compose Edition)

A modern, reactive Android application that allows users to search for GitHub profiles in real-time. This project was built to demonstrate proficiency in Jetpack Compose, Kotlin Flow, and advanced networking architectures.

## Key Features
- **Real-time Search:** Search results update as you type.
- **Debounce Logic:** Optimized API calls using `debounce(500ms)` to prevent server spam.
- **Efficient UI:** Uses `LazyColumn` for high-performance list rendering.
- **Image Loading:** Smooth avatar loading using the **Coil 3** library.
- **Error Handling:** Robust error management within the Repository layer.

## 🛠 Technology Stack
- **UI:** Jetpack Compose
- **Language:** Kotlin
- **Architecture:** MVVM (Model-View-ViewModel) + Repository Pattern
- **Networking:** Retrofit 2
- **Data Parsing:** Kotlinx Serialization (Reflection-free JSON parsing)
- **Concurrency:** Kotlin Coroutines & Flow (`StateFlow`, `mapLatest`, `debounce`)
- **Reactive UI:** `collectAsStateWithLifecycle` for lifecycle-aware state observation.

## Architecture Overview
The app follows **Clean Architecture** principles:
- **Data Layer:** Handles API communication (Retrofit) and JSON mapping.
- **Repository:** Acts as a mediator, providing clean data to the logic layer.
- **ViewModel:** Manages the search pipeline (UserIntent -> State) using Flow operators.
- **UI Layer:** Pure Composable functions that render the current state.

## Technical Highlights
- **Performance:** Used `kotlinx-serialization` to avoid the overhead of Java reflection (GSON).
- **Resource Management:** Used `viewModelScope` and `flatMapLatest` to automatically cancel pending network requests when a new search query is entered.
- **Best Practices:** Implemented `collectAsStateWithLifecycle` to ensure the search stops when the app is in the background.

## API Source
Powered by the [GitHub Search API](https://docs.github.com/en/rest/search/search?apiVersion=2022-11-28#search-users).
