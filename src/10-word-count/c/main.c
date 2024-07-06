/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int countWords(const char *fileName, int *wordCount) {
    FILE *file = fopen(fileName, "r");
    if (file == NULL) {
        return -1; // Error opening file
    }

    char line[1024];
    *wordCount = 0;

    while (fgets(line, sizeof(line), file)) {
        // Split the line into words
        char *token = strtok(line, " \t\n\r");
        while (token != NULL) {
            (*wordCount)++;
            token = strtok(NULL, " \t\n\r");
        }
    }

    fclose(file);
    return 0; // Success
}

int main() {
    printf("Count total words sum\n\n");

    int wordCount;
    int result = countWords("enchiridion-hun.txt", &wordCount);

    if (result == 0) {
        printf("Total words: %d\n", wordCount);
    } else {
        printf("Error: Could not open file.\n");
    }

    return 0;
}
