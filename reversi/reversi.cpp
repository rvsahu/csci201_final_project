#include <vector>
#include <stdexcept>
#include<sstream>

#include "reversi.h"

using namespace std;




void Square::flip()
{
    switch (value_)
    {
    case WHITE:
        value_ = BLACK;
        break;
    case BLACK:
        value_ = WHITE;
        break;
    default:
        break;
    }
}

Square::SquareValue opposite_color(Square::SquareValue value)
{
    switch (value)
    {
    case Square::WHITE:
        return Square::BLACK;
    case Square::BLACK:
        return Square::WHITE;
    default:
        throw invalid_argument("Illegal square value");
    }
}

Square& Board::operator()(char row, size_t column)
{
    if (!is_valid_location(row, column))
    {
        throw out_of_range("Bad row index");
    }
    size_t row_index = row_to_index(row);
    return squares_[row_index][column - 1];
}

Square const& Board::operator()(char row, size_t column) const
{
    if (!is_valid_location(row, column))
    {
        throw out_of_range("Bad row index");
    }
    size_t row_index = row_to_index(row);
    return squares_[row_index][column - 1];
}

bool Board::is_legal_and_opposite_color(
    char row, size_t column, Square::SquareValue turn) const
{
    if (is_valid_location(row, column))
    {
        size_t row_index = row_to_index(row);
        return squares_[row_index][column - 1] != Square::FREE && squares_[row_index][column - 1] != turn;
    }
    return false;
}

bool Board::is_legal_and_same_color(
    char row, size_t column, Square::SquareValue turn) const
{
    if (is_valid_location(row, column))
    {
        size_t row_index = row_to_index(row);
        return squares_[row_index][column - 1] == turn;
    }
    return false;
}

bool Board::is_valid_location(char row, size_t column) const
{
    size_t row_index = row_to_index(row);
    return row_index < dimension_ && column - 1 < dimension_;
}

Checkpoint::Checkpoint(const Board& b, Square::SquareValue turn) :
    board_(b),
    turn_(turn)
{

}

ostream& Board::print(ostream& out) const
{
    out << "  ";
    for (size_t i = 1; i <= dimension_; i++)
    {
        if (i < 10)
        {
            out << " ";
        }
        else
        {
            out << (i / 10);
        }
    }
    out << endl;
    out << "  ";
    for (size_t i = 1; i <= dimension_; i++)
    {
        out << (i % 10);
    }
    out << endl;
    for (size_t i = 0; i < dimension_; i++)
    {
        out << (char)('a' + i) << ':';
        for (size_t k = 0; k < dimension_; k++)
        {
            out << squares_[i][k];
        }
        out << endl;
    }
    return out;
}



void Reversi::prompt() const
{
    cout << board_ << endl;
    cout << (turn_ == Square::BLACK ? "B" : "W");
    cout << " - Enter 'p r/c', 'q', 'c', 'u':" << endl;
}

void Reversi::win_loss_tie_message(size_t white_count, size_t black_count)
{
    cout << board_ << endl;
    if (white_count > black_count)
    {
        cout << "W wins" << endl;
    }
    else if (white_count < black_count)
    {
        cout << "B wins" << endl;
    }
    else
    {
        cout << "Tie" << endl;
    }
    cout << "W=" << white_count << "/B=" << black_count << endl;
}

bool Reversi::is_legal_choice(char row, size_t column, Square::SquareValue turn) const
{
    // Vectors for each cardinal direction
    const size_t direction_count = 8;
    const int direction_row[] =    {-1, -1,  0, +1, +1, +1,  0, -1};
    const int direction_column[] = { 0, -1, -1, -1,  0, +1, +1, +1};

    // Make sure location is free
    if (board_(row, column) != Square::FREE)
    {
        return false;
    }

    // Now check in each directions
    for (size_t d = 0; d < direction_count; d++)
    {
        // Where we're checking
        char cursor_row = row + direction_row[d];
        size_t cursor_column = column + direction_column[d];

        // Move towards the direction while we're on the opposite color
        bool found_opposite = false;
        while (board_.is_legal_and_opposite_color(cursor_row, cursor_column, turn_))
        {
            found_opposite = true;
            cursor_row += direction_row[d];
            cursor_column += direction_column[d];
        }

        // Check if the next thing after is our color
        bool found_same = board_.is_legal_and_same_color(cursor_row, cursor_column, turn_);

        // If this direction is valid, the move is valid, so short circuit and return
        if (found_opposite && found_same) {
            return true;
        }
    }
    return false;
}

bool Reversi::is_game_over() const
{
    for (unsigned char row = 'a'; row < 'a' + board_.dimension(); row++)
    {
        for (size_t column = 1; column <= board_.dimension(); column++)
        {
            if (is_legal_choice(row, column, turn_))
            {
                return false;
            }
        }
    }
    return true;
}


/*------------------- STUDENT TO WRITE -----------------*/
    /**
     * Assigns the internal SquareValue enumeration
     * to the provided input argument.
     * Note: The input is a SquareValue not a full Square
     */
Square& Square::operator=(SquareValue value)
{
    //assign value to the calling object
    value_ = value;
    return *this;
    //return the calling object
    // address dereferenced
}


/*------------------- STUDENT TO WRITE -----------------*/
/**
 * Comparison operators to compare a Square
 * to a SquareValue enumeration value (i.e.
 *  Square::FREE, Square::WHITE, Square::BLACK)
 * Note: We are comparing a SquareValue not a full Square
 */
bool Square::operator==(SquareValue value) const
{
    //check if the two squares
    //have a same value
    //return true if they do
    if (value_ == value)
        return true;
    else
        return false;

}
bool Square::operator!=(SquareValue value) const
{
    //check if the two squares
    //have a different value
    //return true if they do
    if (value_ == value)
        return false;
    else
        return true;
}


/*------------------- STUDENT TO WRITE -----------------*/
/**
 *  ostream operator for a Square object that outputs
 *    '-' for FREE, 'B' for BLACK, and 'W' for WHITE.
 *  Note: Since data members in the Square struct are public
 *    we do not need to make this a friend function.
 */
std::ostream& operator<<(std::ostream& out, const Square& square)
{
    //overload the << operator
    //to print out accordingly to
    //the square value
    if (square.value_ == Square::FREE)
        out << '-';
    else if (square.value_ == Square::WHITE)
        out << 'W' ;
    else if (square.value_ == Square::BLACK)
        out << 'B';
    return out;
}



/*------------------- STUDENT TO WRITE -----------------*/
/**
 * Initializing constructor
 */
Board::Board(size_t s)
{

    //construct a board
    dimension_ = s;
    //dynamically allocate squares
    squares_ = new Square*[s];

    for (size_t i = 0; i < dimension_; i++)
    {
        squares_[i] = new Square[s];
    }
}


Board::Board(const Board& og)
{
    //overload the board to
    //receive appropriate
    //square values from the
    //prev board
    Square::SquareValue temp;
    dimension_ = og.dimension_;

    squares_ = new Square*[og.dimension_];

    //create squares

    for (size_t i = 0; i < og.dimension_; i++)
    {
        squares_[i] = new Square[og.dimension_];
    }


    for (size_t i = 0; i < og.dimension_; i++)
    {
        for (size_t j = 0; j < og.dimension_; j++)
        {
            temp = og(char(i+'a'),j+1).value_;
            squares_[i][j].value_ = temp;
        }
    }
}

Board::~Board()
{

    //destruct the board
    //when the player undos
    //or when the game ends
    for (size_t i = 0; i < dimension_; i++)
    {
        delete [] squares_[i];
    }
    
    delete [] squares_;
}

Board& Board::operator=(const Board& og)
{
    //overload the = operator
    //to assign square values
    //to a square
    int dim = og.dimension();
    Square::SquareValue temp;

    for (int i = 0; i < dim; i++)
    {
        for (int j = 0; j < dim; j++)
        {
            temp = og(char(i+'a'),j+1).value_;
            squares_[i][j].value_ = temp;
        }
    }
    //return a dereferenced address
    //to the calling object
    return *this;
}



/*------------------- STUDENT TO WRITE -----------------*/
/**
 *  Outputs the board
 *  Should be a simple wrapper for Board::print().
 */
std::ostream& operator<<(std::ostream& out, const Board& board)
{
    //overload the << operator
    //to print the board
    board.print(out);
    return out;
}

/*------------------- STUDENT TO WRITE -----------------*/
/**
 * Constructs the board of a given side length (dimension)
 * Should set the middle 2x2 elements of the board to:
 *    BW
 *    WB
 */
Reversi::Reversi(size_t size) : board_(size)
{
    //reversi constructor
    turn_ = Square::BLACK;
    char bx1, bx2, wx1, wx2;
    int by1, by2, wy1, wy2;
    //index to the appropriate
    //four middle squares
    //by assigning the correct row
    //and column values
    size_t n = board_.dimension();
    by1 = 'a' + n/2 -1;
    by2 = 'a' + n/2;
    wy1 = 'a' + n/2 -1;
    wy2 = 'a' + n/2;

    bx1 = n/2;
    bx2 = n/2 + 1;
    wx1 = n/2 + 1;
    wx2 = n/2;
    //set the four middle squares
    //to Bs and Ws
    board_(by1, bx1).value_ = Square::BLACK;
    board_(by2, bx2).value_ = Square::BLACK;
    board_(wy1, wx1).value_ = Square::WHITE;
    board_(wy2, wx2).value_ = Square::WHITE;

}

/*------------------- STUDENT TO WRITE -----------------*/
/**
 * Play the entire game.
 * Uses private helper functions to modularize the code.
 */
void Reversi::play()
{ 
    //play function
    while (is_game_over() == false)
    {
        //run while there are legal moves
        //or when the player does not
        //quit the game
        string x;
        stringstream ss;
        char row;
        size_t col;
        char choice;

        //print prompt
        prompt();
        getline(cin, x);
        //ss.clear();
        ss << x;
        ss >> choice; 
        

        if (choice == 'p')
        {
            //take the square coordinate
            ss >> row;
            ss >> col;

            cout << row << col << endl;
            //if it is a legal choice
            //change the square value
            if(is_legal_choice(row, col, turn_))
            {
                //if the player input is legal
                //set the square value to the
                //player color
                board_(row, col).value_ = turn_;

                //see if other squares can be flipped
                //and flip accordingly
                flipsquares(row, col, turn_);


                //other player's turn
                turn_ = opposite_color(turn_);
            }

            
        }

        else if (choice == 'q')
        {
            //if the player chooses quit
            //exit out of the loop
        	break;      

        }
        else if (choice == 'c')
        {
            //save checkpoint if
            //the player types c
        	//cout << "entered c" << endl;
        	save_checkpoint();
        }
        else if (choice == 'u')
        {
            //go back to the last checkpoint
        	undo();
        }
    }

    //count the squares at the end of the game
    //to see who won using a for loop
    int whitec = 0;
	int blackc = 0;

	size_t size = board_.dimension();

	for (size_t i = 0; i < size;i++)
	{
		for (size_t j = 0; j < size;j++)
    		if (board_(char(i + 'a'), j+1).value_ == Square::BLACK)
    		{
    			blackc++;
    		}
    		else if (board_(char(i + 'a'), j+1).value_ == Square::WHITE)
    		{
    			whitec++;
    		}
	}
    //print the win loss message

	win_loss_tie_message(whitec, blackc);
}
	

 


/*------------------- STUDENT TO WRITE -----------------*/
/**
 * Makes a checkpoint of the current board and player turn
 * and saves it in the history vector
 */
void Reversi::save_checkpoint()
{
    //construct a checkpoint
	Checkpoint temp(board_, turn_);
    //push the checkpoint to the history vector
	history_.push_back(temp);
	
	return;
}


/*------------------- STUDENT TO WRITE -----------------*/
/**
 * Overwrites the current board and player turn with the
 *  latest saved checkpoint. If no checkpoint is available
 *  simply return.
 */

void Reversi::undo()
{
	//set the game board and turn
    //to the latest checkpoint
	board_ = history_.back().board_;
	turn_ = history_.back().turn_;
    //then delete checkpoint
	history_.pop_back();
	return;

}


/* You may add other private helper functions */


//play function
//counting tiles
//destructor
//remaining functions

void Reversi::flipsquares(char row, size_t col, Square::SquareValue turn)
{
    //flip squares in between two same colors
    const size_t direction_count = 8;
    const int direction_row[] =    {-1, -1,  0, +1, +1, +1,  0, -1};
    const int direction_column[] = { 0, -1, -1, -1,  0, +1, +1, +1};

    //check each direction
    //if there is a same color square
    //on the end

    for (size_t d = 0; d < direction_count; d++)
    {
        //create a vector to add opposite colors
        //of the color of the square the player
        //has chosen
        vector<Square*> List;
        //cursors hold the index
        //of the square chosen by the player
        char cursor_row = row + direction_row[d];
        size_t cursor_column = col + direction_column[d];

        while(board_.is_legal_and_opposite_color(cursor_row, cursor_column, turn))
        {
            //add all the squares with values
            //opposite from the values chosen by the
            //user
            Square* sq = &board_(cursor_row, cursor_column);
            List.push_back(sq);
            cursor_row = cursor_row + direction_row[d];
            cursor_column = cursor_column + direction_column[d];
        }

        while(board_.is_legal_and_same_color(cursor_row, cursor_column, turn)
            && List.empty() == false)
        {
            //flip only if
            //the list holds values
            //therefore has opposite values
            //from the user chosen squares
            //and finds the same square value
            //chosen by the user
            List.back() -> flip();
            //after flipping delete
            List.pop_back();
        }
    }
}