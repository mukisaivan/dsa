function sum(a, b) {
  return a + b
}

function sum2(a) {
  return function inside(b) {
    return a + b
  }
}

console.log(sum2(2)(4))
console.log(sum(2, 4))

// deep copies

let original = {
  name: "John",
  address: {
    city: "New York",
  },
}

let shallowCopy = { ...original } // Shallow copy using the spread operator

shallowCopy.name = "Doe" // This only modifies the shallow copy
console.log(original.name) // "John", the original name remains unchanged

shallowCopy.address.city = "Los Angeles" // This modifies the nested object
console.log(original.address.city) // "Los Angeles", the original is also affected

let original2 = {
  name: "John",
  address: {
    city: "New York",
  },
}

let deepCopy = JSON.parse(JSON.stringify(original2)) // Deep copy using JSON methods

deepCopy.name = "Doe" // This only modifies the deep copy
console.log(original2.name) // "John", the original remains unchanged

deepCopy.address.city = "Los Angeles" // This only modifies the deep copy
console.log(original2.address.city) // "New York", the original remains unchanged

// writing a sum function to make sure that the direct input and the curry input returns the same results

function sum(a, b) {
  // If both arguments are provided
  if (b !== undefined) {
    return a + b
  }

  // If only one argument is provided, return a function to take the second argument
  return function (b) {
    return a + b
  }
}

// Usage:
console.log(sum(2, 4)) // Direct usage, returns 6
console.log(sum(2)(4)) // Curried usage, also returns 6
