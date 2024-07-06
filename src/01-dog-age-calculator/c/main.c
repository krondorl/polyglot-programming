#include <stdio.h>
#include <math.h>
#include <string.h>

typedef enum {
    AGE_RESULT_NUMBER,
    AGE_RESULT_STRING
} AgeResultType;

typedef struct {
    AgeResultType type;
    union {
        int number;
        char string[50];
    } value;
} AgeResult;

AgeResult calculate_dog_age(int age) {
    AgeResult result;
    if (age < 1) {
        result.type = AGE_RESULT_STRING;
        strcpy(result.value.string, "Error: age should be at least 1.");
    } else {
        result.type = AGE_RESULT_NUMBER;
        result.value.number = (int)round(16 * log(age) + 31);
    }
    return result;
}

int main() {
    printf("Dog Age Calculator\n");
    int age = 1;
    AgeResult dog_age = calculate_dog_age(age);
    if (dog_age.type == AGE_RESULT_NUMBER) {
        printf("Dog age %d in human years is %d\n", age, dog_age.value.number);
    } else if (dog_age.type == AGE_RESULT_STRING) {
        printf("%s\n", dog_age.value.string);
    }
    return 0;
}
