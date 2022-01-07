# Android JVM Adapter

This module uses the `cargo-ndk-android` plugin to automatically build and copy over the necessary libraries to run Rust code in Android. It then provides a class that matches the path and names required by the library so the code can be called from other JMV languages without having to deal with native methods.

The `jniLibs` folder is automatically created and populated at build time.

#### Useful links

* https://github.com/willir/cargo-ndk-android-gradle