/*!
 * Polyglot Programming
 *
 * Copyright (c) 2024 Adam Burucs
 *
 * MIT Licensed
 */

enum RootType {
  RealRoots,
  OnlyRoot,
  ImaginaryRoots,
  NoRoots,
}

interface EquationRoots {
  rootType: RootType;
  roots1?: number | string;
  roots2?: number | string;
}

function solveQe(a: number, b: number, c: number): EquationRoots {
  let discriminant = b * b - 4 * a * c;
  if (discriminant > 0) {
    let x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    let x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    return {
      rootType: RootType.RealRoots,
      roots1: x1,
      roots2: x2,
    };
  } else if (discriminant === 0) {
    let x1 = -b / (2 * a);
    return {
      rootType: RootType.OnlyRoot,
      roots1: x1,
    };
  } else if (discriminant < 0) {
    let denominator = 2 * a;
    let real_part = -b / (2 * a);
    let imaginary_result = Math.sqrt(Math.abs(discriminant)) / denominator;
    return {
      rootType: RootType.ImaginaryRoots,
      roots1: `${real_part} + ${imaginary_result}i`,
      roots2: `${real_part} - ${imaginary_result}i`,
    };
  } else {
    return { rootType: RootType.NoRoots };
  }
}

function printSolver(a: number, b: number, c: number) {
  let solutions = solveQe(a, b, c);
  console.log(`${a}x^2 + ${b}x + ${c} = 0`);

  switch (solutions.rootType) {
    case RootType.RealRoots:
      console.log("Roots are real and distinct");
      console.log(`Root1 = ${solutions.roots1}`);
      console.log(`Root2 = ${solutions.roots2}`);
      break;
    case RootType.ImaginaryRoots:
      console.log("Imaginary Roots");
      console.log(`Root1 = ${solutions.roots1}`);
      console.log(`Root2 = ${solutions.roots2}`);
      break;
    case RootType.OnlyRoot:
      console.log("There is only one root");
      console.log(`Root = ${solutions.roots1}`);
      break;
    case RootType.NoRoots:
      console.log("No roots for given parameters.");
      break;
  }

  console.log();
  console.log("***");
  console.log();
}

function main() {
  console.log("Quadratic equation solver");
  console.log();
  printSolver(4.0, 3.0, 2.0);
  printSolver(1.0, -8.0, 5.0);
  printSolver(-4.0, 12.0, -9.0);
}

main();
