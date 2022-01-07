use core_lib::{add as lib_add, reverse as lib_reverse};

#[no_mangle]
pub extern "C" fn add(lhs: i32, rhs: i32) -> i32 {
    lib_add(lhs, rhs)
}