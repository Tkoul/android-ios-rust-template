use core_lib::{add, reverse};
use jni::objects::{JClass, JString};
use jni::sys::{jint, jstring};
use jni::JNIEnv;

#[no_mangle]
pub extern "C" fn Java_app_raybritton_corelib_adapter_Core_add_1int(_env: JNIEnv, _obj: JClass, lhs: jint, rhs: jint) -> jint {
    add(lhs, rhs)
}

#[no_mangle]
pub extern "C" fn Java_app_raybritton_corelib_adapter_Core_reverse_1string(env: JNIEnv, _obj: JClass, text: JString) -> jstring {
    let rust_string = env.get_string(text).unwrap().into();
    let reserved = reverse(rust_string);
    let output = env.new_string(reserved).unwrap();
    output.into_inner()
}