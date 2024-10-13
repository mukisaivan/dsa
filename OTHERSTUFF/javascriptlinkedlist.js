class Node {
  constructor(data) {
    this.data = data
    this.next = null
  }
}

class LinkedList {
  constructor() {
    this.head = null
  }

  // Add a node at the end of the list
  append(data) {
    const newNode = new Node(data)
    if (!this.head) {
      this.head = newNode
      return
    }
    let current = this.head
    while (current.next) {
      current = current.next
    }
    current.next = newNode
  }

  // Add a node at the beginning of the list
  prepend(data) {
    const newNode = new Node(data)
    newNode.next = this.head
    this.head = newNode
  }

  // Remove a node with a specific value
  remove(data) {
    if (!this.head) return

    if (this.head.data === data) {
      this.head = this.head.next
      return
    }

    let current = this.head
    while (current.next && current.next.data !== data) {
      current = current.next
    }

    if (current.next) {
      current.next = current.next.next
    }
  }

  // Traverse the list and apply a callback to each node's data
  traverse() {
    let current = this.head

    let output = ""
    while (current) {
      output += current.data + (current.next ? " --> " : "")
      current = current.next
    }

    console.log(output)
  }
}

const list = new LinkedList()
list.append(10)
list.append(30)
list.append(40)
list.append(50)
list.prepend(5)
list.traverse() // Outputs:
list.remove(10)
list.traverse() // Outputs: 5, 20
