##Toy Robot Simulation App
The Toy Robot Simulation App is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units. There are no other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.

The app can read in commands of the following form:

PLACE X,Y,F: Place the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST, or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner.
MOVE: Move the toy robot one unit forward in the direction it is currently facing.
LEFT: Rotate the robot 90 degrees to the left without changing its position.
RIGHT: Rotate the robot 90 degrees to the right without changing its position.
REPORT: Announce the X,Y and facing of the robot.
A robot that is not on the table can ignore the MOVE, LEFT, RIGHT, and REPORT commands.

#Getting Started
Environment requirements: JDK or JRE 7 or above.

Clone the repository to your local machine.
Navigate to the root directory of the repository.
Compile the source code by running the command javac *.java.
Run the app by running the command java Starter.
