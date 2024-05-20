/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

/*!
 *  This code is based on my Arcanus Psw project.
 *
 *  https://github.com/krondorl/arcanus-psw
 *
 *  Copyright (c) 2023 Adam Burucs. MIT license.
 */

package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Password generator");
        String p32 = RandomGenerator.generatePassword(32);
        System.out.println(p32);
    }
}