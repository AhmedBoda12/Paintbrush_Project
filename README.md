
# Paintbrush

A simple painting application built with Java.

## Author

Ahmed Abouelella
Noura Khalid

## Features

- Draw shapes and freehand strokes
- Customize colors
- Clear canvas functionality

## Requirements

- Java 8 or higher

## Installation

1. Clone or download the project
2. Navigate to the project directory
3. Compile: `javac -d bin src/*.java`
4. Run: `java -cp bin Main`

## Usage

- Select a drawing tool from the toolbar
- Click and drag on the canvas to draw or use freehand
- Use the color picker to change colors
- Use eraser to remove 
- Click "ClearAll" to start over

## Project Structure

```
Paintbrush/
├── src/
│   ├── enums
|           ├── ShapeType.java
|           ├── ToolType.java
|   ├── models
│           ├── Freehand.java
|           ├── LineShape.java
|           ├── MainShape.java
|           ├── OvalShape.java
|           ├── RectangleShape.java
│   |── views
│           ├── BottomPanel.java
|           ├── DrawingPanel.java
|           ├── PaintBrushFrame.java
|           ├── ToolsPanel.java
│   └── App.java
└── README.md
```


