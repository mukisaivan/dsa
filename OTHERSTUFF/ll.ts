class NodeO<T> {
  public data: T
  public next: NodeO<T> | null = null

  constructor(data: T) {
    this.data = data
  }
}
class LinkedListO<T> {
  private head: NodeO<T> | null = null

  public append(data: T): void {
    const newNode = new NodeO(data)
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

  public prepend(data: T): void {
    const newNode = new NodeO(data)
    newNode.next = this.head
    this.head = newNode
  }

  public remove(data: T): void {
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

  public traverse(callback: (data: T) => void): void {
    let current = this.head
    while (current) {
      callback(current.data)
      current = current.next
    }
  }
}

const l = new LinkedListO<number>()
l.append(10)
l.append(20)
l.prepend(5)
l.traverse(console.log) // Outputs: 5, 10, 20
l.remove(10)
l.traverse(console.log) // Outputs: 5, 20
