# Magical-Arena

## Description
Magical Arena is a players battle game with attributes like strength,attack and health

## Compile and run the source code
1. Compile the Java files using a Java compiler using command <br>
   `javac Main.java`
2. Run the game using command <br>
   `java Main`
3. if code is not working in terminal Simply copy and paste code in any ide with java 

## How to play
1. Enter names for Player 1 and Player 2 as prompted.
2. Players are given a option to manually add the attributes value(1) or Randomly assign for each(2).
3. Make sure u add values health <= 100,strength <= 20 ,attack<=20 for better gameplay and for fast result
4. Press '1' to roll the die and simulate attacks during each player's turn.
5. Leaderboard / Results can be seen everytime after each turn is completed
6. The game continues until one player's health reaches zero.
7. The winner is displayed at the end of the game.
    
## Basic Explaination

1. Firstly after choice is choosen make sure to add values accordinly.If you add greater than bound then it will take the maximim as health
2. DisplayResult() method displays result accordingly.
3. After any attack the result will be shown as "Nothing happened" or "Defenders health decreased by x to y"
4. Code is properly executing well.With full explantion and base cases 
5. For calculation Simply ressursive approach is taken in consideration where a attacker will be the next defender
