pub fn add(lhs: i32, rhs: i32) -> i32 {
    return lhs + rhs;
}

pub fn reverse(text: String) -> String {
    return text.chars().rev().collect();
}

#[derive(Debug, Eq, PartialEq, Clone)]
pub struct Person {
    first_name: String,
    last_name: String,
}

impl Person {
    pub fn new(first_name: String, last_name: String) -> Self {
        Person { first_name, last_name }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_add() {
        assert_eq!(add(2, 2), 4);
    }

    #[test]
    fn test_reverse() {
        assert_eq!(reverse(String::from("This test")), String::from("tset sihT"));
    }

    #[test]
    fn test_person() {
        assert_eq!(
            Person::new(String::from("F"), String::from("L")),
            Person { first_name: String::from("F"), last_name: String::from("L") }
        )
    }
}
