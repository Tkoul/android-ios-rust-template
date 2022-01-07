# Multiplatform Android/iOS/Rust Template

These projects show the basics of creating a Rust library and then calling it from an Android app and an iOS app.

## Technical info

The library is blocking so callers should wrap it with something to run on a different thread, if necessary. 

## Project Layout

* `core-lib`
  * This is the core library written in Rust
* `jvm-adapter-rust`
  * Provides JVM friendly names for `core-lib`
* `android`
  * `adapter`
    * This provides a Java class to use `jvm-adapter-rust` 
  * `app`
    * An Android frontend to use the library 
* `swift-adapter`
  * Provides an interface between Swift and Rust
* `ios`
  * This is the iOS implementation

## Usage

### Setup

You'll need Rust, Android Studio and Xcode installed.

#### iOS

* Add iOS targets for Rust
  * `rustup target add aarch64-apple-ios armv7-apple-ios armv7s-apple-ios x86_64-apple-ios i386-apple-ios`
* Add iOS cross compiler for Rust
  * `cargo install cargo-lipo`

#### Android

* Install `NDK 22.1.7171670`
  * (SDK Manager)
* Add Android targets for Rust
  * `rustup target add armv7-linux-androideabi aarch64-linux-android i686-linux-android x86_64-linux-android`
* Install NDK cross compiler for Rust
  * `cargo install cargo-ndk`
