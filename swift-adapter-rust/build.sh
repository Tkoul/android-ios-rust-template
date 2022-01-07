cargo clean
cargo build --release --target aarch64-apple-ios-sim
cargo lipo --release