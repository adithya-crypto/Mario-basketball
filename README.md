# Baseball Stats Analyzer

## Description
The Baseball Stats Analyzer is a Java program designed to analyze and display statistics for baseball players. It reads player data from a text file, calculates various batting metrics such as batting average, on-base percentage, hits, walks, strikeouts, and hits by pitch, and then displays league leaders for each category.

## Features
- **Data Input**: Reads player data from a text file in a specific format.
- **Data Processing**: Calculates batting metrics based on player statistics.
- **League Leader Display**: Displays league leaders for each category, including batting average, on-base percentage, hits, walks, strikeouts, and hits by pitch.
- **Tie Handling**: Handles ties in the league leaders by displaying all tied players together.
- **User-Friendly Interface**: Provides clear instructions and prompts for inputting the filename containing player data.

## Usage
1. Clone the repository to your local machine.
2. Compile the Java files using the command `javac *.java`.
3. Run the program using the command `java Main`.
4. Follow the on-screen instructions to input the filename containing player data.
5. View the league leaders for each category displayed in the console.

## Input File Format
The input file should contain player names and their corresponding batting records, separated by whitespace. Each line represents one player's data, with the format:
```
[Player Name] [At-bats] [Hits] [Walks] [Strikeouts] [Hits by Pitch] [Batting Average] [On-base Percentage]
```
For example:
```
DK 11 10 0 0 0 0.909 0.909
Link 34 15 4 12 0 0.441 0.500
...
```

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author
This project was created by Adithya Sriramoju. For questions or feedback, please contact adithyas042@gmail.com.
