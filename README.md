# Wardrobe Dequeuer

## Project Overview
A Java-based console application for managing clothing items in a wardrobe using a custom linked deque data structure.  
This system allows users to add clothing items, automatically organize them by purchase date, and manage donations based on age and value criteria.

## How to Run

### Prerequisites
- Java JDK 8 or higher
- BlueJ IDE (recommended) or any Java development environment
- JUnit 5 (for running tests)

### Compilation and Execution
1. Open the project in BlueJ
2. Compile all Java files
3. Run the `Wardrobe` class
4. Follow the menu prompts to interact with the system

## Features
- **Clothing Management**: Add and organize clothing items by category and purchase date
- **Smart Donation System**: Automatically identifies items eligible for donation
- **Category Tracking**: Limits per clothing category (max 10 items per type)
- **Date Validation**: Ensures valid purchase dates with proper format checking
- **Price Evaluation**: Determines "pricey" items based on category-specific thresholds
- **Custom Data Structure**: Uses a linked deque with array-based nodes for efficient operations

## Clothing Categories & Price Thresholds

### Available Categories:
- **COAT** ($500+ considered pricey)
- **DENIM** ($125+ considered pricey)
- **PANTS** ($200+ considered pricey)
- **SHIRT** ($100+ considered pricey)
- **SWEATER** ($150+ considered pricey)
- **SHOE** ($200+ considered pricey)

### Donation Rules:
- Items 10+ years old AND not pricey are automatically donated
- Pricey items 10+ years old are moved to the back of the wardrobe
- Maximum 10 items allowed per category

## Key Classes & Methods

### Wardrobe (Main Class)
- `main()` - Program entry point with menu system
- `appended()` - Adds new clothing items with validation
- `updateWardrobe()` - Manages donations and item organization
- `verifiedDate()` - Validates purchase date format (MMDDYYYY)

### LinkedDeque (Custom Data Structure)
- `pushFront()/pushBack()` - Insert items at either end
- `popFront()/popBack()` - Remove items from either end
- `peekFront()/peekBack()` - View items without removal
- Custom iterator for traversing the deque

### Clothes (Data Model)
- `compareTo()` - Compares items by purchase date
- `isPricey()` - Determines if item meets price threshold
- `toString()` - Formats clothing information for display

## Usage Instructions

1. **Main Menu Options**:
   - Enter new clothing item (requires date, price, and category)
   - Display current wardrobe contents
   - Exit the system

2. **Adding Clothing Items**:
   - Purchase date must be in MMDDYYYY format
   - Price must be a positive number
   - Category must be selected from available options
   - Items are automatically organized by purchase date

3. **Automatic Management**:
   - System automatically donates eligible items
   - Maintains category limits
   - Organizes items chronologically

## Input Validation
- Purchase dates must be valid calendar dates
- Prices must be positive numbers
- Categories must be valid selections (1-6)
- Date format must be exactly 8 digits (MMDDYYYY)

## Technical Details
- **Data Structure**: Custom linked deque with array-based nodes (8-element arrays)
- **Algorithm**: Implements donation logic based on age and value
- **Sorting**: Maintains chronological order by purchase date
- **Validation**: Comprehensive input checking with user feedback
- **Testing**: Complete JUnit test coverage for core functionality

## Author
**Victor Hernandez Jr**  
Lafayette College  
CS150 Project 3, Fall 2022

## Academic Context
This project was developed for CS150 (Data Structures & Algorithms) at Lafayette College, demonstrating advanced data structure implementation, algorithm design, and object-oriented programming principles.

## Version
November 11, 2022
