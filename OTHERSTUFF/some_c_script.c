#include <stdio.h>
#include <stdlib.h>
int main2()
{

  int a = 5; // Declare an integer variable
  int *p;    // Declare a pointer to an integer (currently not pointing to anything)

  int *ptr = (int *)malloc(sizeof(int));
  /*-

  malloc(sizeof(int)):

    malloc is a function that allocates a specified amount of memory on the heap.
    sizeof(int) calculates the size (in bytes) required for one integer. Typically, this is 4 bytes on most systems.
    So, malloc(sizeof(int)) allocates enough memory to store one integer and returns a pointer of type void*, which is a generic pointer type.
    Type Casting (int *):

    In C, malloc returns a pointer of type void*. A void* pointer can point to any data type but cannot be dereferenced directly without casting to a specific pointer type.
    The cast (int *) converts the void* returned by malloc into an int*, indicating that this pointer will point to an integer.
    This cast is not strictly necessary in C (though it is required in C++), but it can help with code readability and clarify that the pointer is intended to hold an integer.

  */

  if (ptr == NULL)
  {
    printf("Memory allocation failed.\n");
    return 1; // Exit if malloc fails
  }

  *ptr = 100; // Assign a value to the allocated memory
  /*
    Now, if you mistakenly do :
    ptr = 100; // Incorrect: this assigns an address value to the pointer
  */

  printf("Value assigned: %d\n", *ptr); // Output: 100

  p = &a; // Store the address of 'a' in pointer 'p'

  printf("Address of 'a': %p\n", &a); // Print the address of 'a'
  printf("Value of 'p': %p\n", p);    // Print the value of 'p' (which is the address of 'a')

  printf("Value of 'a': %d\n", a);          // Print the value of 'a'
  printf("Value pointed by 'p': %d\n", *p); // Dereference the pointer to print the value of 'a'

  free(ptr); // Free the allocated memory

  return 0;
}

int main3()
{

  // 2d array

  int rows = 3, cols = 4;

  // Allocate memory for an array of pointers (for each row)
  int **arr = (int **)malloc(rows * sizeof(int *));

  // Allocate memory for each row
  for (int i = 0; i < rows; i++)
  {
    arr[i] = (int *)malloc(cols * sizeof(int));
  }

  // Assign values to the 2D array
  for (int i = 0; i < rows; i++)
  {
    for (int j = 0; j < cols; j++)
    {
      arr[i][j] = i + j;
    }
  }

  // Print the 2D array
  for (int i = 0; i < rows; i++)
  {
    for (int j = 0; j < cols; j++)
    {
      printf("%d ", arr[i][j]);
    }
    printf("\n");
  }

  // Free the memory
  for (int i = 0; i < rows; i++)
  {
    free(arr[i]); // Free each row
  }
  free(arr); // Free the array of pointers

  return 0;
}

int main4()
{

  int rows = 3, cols = 3;

  int **arr = (int **)malloc(rows * sizeof(int *)); // allocating memory for the array

  for (int i = 0; i < rows; i++)
  {
    arr[i] = (int *)malloc(cols * sizeof(int));
  }

  for (int i = 0; i < rows; i++)
  {
    for (int j = 0; j < cols; j++)
    {
      arr[i][j] = i + j;
    }
  }

  for (int i = 0; i < rows; i++)
  {
    for (int j = 0; j < cols; j++)
    {
      printf("%d ", arr[i][j]);
    }
    printf("\n");
  }

  for (size_t i = 0; i < rows; i++)
  {
    free(arr[i]);
  }

  free(arr);

  return 0;
}

struct Node
{
  int data;
  struct Node *next;
};

// Function to create a new node
struct Node *createNode(int data)
{
  // Allocate memory for a new node
  struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));

  // Set the node's data
  newNode->data = data;

  // Initialize the next pointer to NULL (end of the list for now)
  newNode->next = NULL;

  return newNode;
}

// Function to add a node at the end of the linked list
void append(struct Node **head, int data)
{
  // Create a new node
  struct Node *newNode = createNode(data);

  // If the list is empty, make the new node the head
  if (*head == NULL)
  {
    *head = newNode;
    return;
  }

  // Otherwise, traverse to the last node
  struct Node *temp = *head;
  while (temp->next != NULL)
  {
    temp = temp->next;
  }

  // Point the last node's next to the new node
  temp->next = newNode;
}

// Function to print the linked list
void printList(struct Node *head)
{
  struct Node *temp = head;
  while (temp != NULL)
  {
    printf("%d -> ", temp->data);
    temp = temp->next;
  }
  printf("NULL\n");
}

// Function to free the memory of the linked list
void freeList(struct Node *head)
{
  struct Node *temp;
  while (head != NULL)
  {
    temp = head;
    head = head->next;
    free(temp); // Free each node
  }
}

int main()
{

  struct Node *head = NULL; // Initialize the head of the list to NULL

  // Append some nodes to the list
  append(&head, 10);
  append(&head, 20);
  append(&head, 30);

  // Print the linked list
  printf("Linked List: ");
  printList(head);

  // Free the linked list
  freeList(head);

  return 0;
}