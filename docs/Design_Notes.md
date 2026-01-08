# Design Notes

## Why ArrayList instead of Array

**ArrayList was chosen over arrays for the following reasons:**

1. **Dynamic Size**: ArrayList can grow and shrink dynamically, while arrays have fixed size
2. **Built-in Methods**: ArrayList provides useful methods like `add()`, `remove()`, `stream()`, `filter()`
3. **Type Safety**: Generic ArrayList `<StudentEntity>` provides compile-time type checking
4. **Memory Management**: ArrayList handles memory allocation automatically
5. **Integration**: Works seamlessly with Java Streams API for filtering and searching

## Static Members Usage

**Static members were used in the following locations:**

1. **Main Method**: `public static void main()` - Required entry point for Java applications
2. **Person Class**: `private static long idCounter` - Shared counter across all instances to generate unique IDs

**Why static was used:**
- Main method must be static to be called by JVM without creating an instance
- ID counter needs to be shared across all Person instances to ensure uniqueness

## Inheritance Implementation

**Inheritance was implemented in the entity hierarchy:**

```
Person (Base Class)
├── StudentEntity (extends Person)
└── CourseEntity (extends Person)
```

**What was gained from inheritance:**

1. **Code Reuse**: Common properties (id, active) are defined once in Person class
2. **Polymorphism**: Can treat StudentEntity and CourseEntity as Person objects
3. **Consistent ID Management**: All entities get unique IDs from the same counter
4. **Maintainability**: Changes to common properties only need to be made in one place
5. **Extensibility**: Easy to add new entity types that extend Person

## Clean Code Principles Applied

### Meaningful Method Names
- `addStudent()` instead of `add()`
- `deactivateStudent()` instead of `update()`
- `displayStudentDetails()` instead of `show()`
- `enrollStudent()` instead of `enroll()`

### Short, Focused Methods
- Each method has a single responsibility
- Methods are kept under 20 lines where possible
- Complex operations are broken into smaller methods

### Clear Variable Names
- `studentEntities` instead of `list`
- `searchedStudent` instead of `result`
- `enrollmentDate` instead of `date`
- `durationInWeeks` instead of `duration`