# JVM Adapter (Rust)

The JVM requires native methods to have specific names to be able to call them from Java, Kotlin, etc. This project contains methods with valid names that turn call the library directly.

The output from this project could be used any JVM compatible system, such desktop or Android. It requires that the project that uses it creates a class named `app.raybritton.corelib.adapter.Core` that reference the native methods `add_int` and `reverse_string`, see `android/adapter` for reference.