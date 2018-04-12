package com.android.rexben.newtic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class TwoPlayers extends AppCompatActivity {

    //Declaring the variables as class variables(fields)
    private boolean turn = false;
    private char table[][] = new char[3][3];
    int count = 0;
    int scoreX = 0;
    int scoreO = 0;

    String first = "";
    String second = "";

    private Button setX;
    private Button setO;

    private char firstC;
    private char secondC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);

        //Casting and referencing views by their Ids
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        playAgain(findViewById(R.id.tableLayout));


        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow r = (TableRow) T.getChildAt(y);
                for (int x = 0; x < r.getChildCount(); x++) {
                    View V = r.getChildAt(x);
                    V.setOnClickListener(new playGame(x, y));

                    disableAllButtons();
                }
            }
        }
        //Button set for new game
        Button c = (Button) findViewById(R.id.playAgain);
        c.setOnClickListener(new OnClickListener() {
            public void onClick(View n) {
                playAgain(n);
            }

        });

        //choose X
        setX = (Button) findViewById(R.id.setX);
        setX.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                first = "X";
                second = "O";

                firstC = 'X';
                secondC = 'O';

                setX.setEnabled(false);
                setO.setEnabled(true);
                enableAllButtons();

            }
        });

        //choose O
        setO = (Button) findViewById(R.id.setO);
        setO.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                first = "O";
                second = "X";

                firstC = 'O';
                secondC = 'X';

                setO.setEnabled(false);
                setX.setEnabled(true);
                enableAllButtons();
            }
        });



    }

    //the class handles the game
    private class playGame implements OnClickListener {

        private int x = 0;
        private int y = 0;

        playGame(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void onClick(View view) {
            if (view instanceof Button) {
                switch ((count % 2)) {
                    case 0:
                        Button B = (Button) view;
                        table[x][y] = firstC;
                        B.setText(first);
                        B.setEnabled(false);
                        turn = !turn;
                        declareWinner();
                        count++;
                        break;
                    case 1:
                        Button C = (Button) view;
                        table[x][y] = secondC;
                        C.setText(second);
                        C.setEnabled(false);
                        turn = !turn;
                        declareWinner();
                        count++;
                        break;
                }

            }
        }
    }

    //method that is triggered when the Play Again
    //button is clicked
    public void playAgain(View view) {
        turn = false;
        table = new char[3][3];
        resetButtons();
    }

    //Resets the game board and not the scoreX board
    private void resetButtons() {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow Re = (TableRow) T.getChildAt(y);
                for (int x = 0; x < Re.getChildCount(); x++) {
                    if (Re.getChildAt(x) instanceof Button) {
                        Button B = (Button) Re.getChildAt(x);
                        B.setText(" ");
                        B.setEnabled(true);
                    }
                }
            }
        }
    }

    //Checks if there is a win and it updates it on the screen
    //with a toast message
    //Updates the scoreX board
    private void declareWinner() {
        TextView scoreXText = (TextView) findViewById(R.id.xResult);
        TextView scoreXText2 = (TextView) findViewById(R.id.oResult);

        //checking for X's wins
        //Diagonal win
        if (table[0][0] == firstC) {
            if ((table[1][1] == firstC) && (table[2][2] == firstC)) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //diagonal '/'
        if (table[2][0] == firstC) {
            if ((table[1][1] == firstC) && (table[0][2] == firstC)) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //horizontal1
        if (table[0][0] == firstC) {
            if (table[1][0] == firstC && table[2][0] == firstC) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //horizontal2
        if (table[0][1] == firstC) {
            if (table[1][1] == firstC && table[2][1] == firstC) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //horizontal3
        if (table[0][2] == firstC) {
            if (table[1][2] == firstC && table[2][2] == firstC) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //vertical1
        if (table[0][0] == firstC) {
            if (table[0][1] == firstC && table[0][2] == firstC) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //vertical2
        if (table[1][0] == firstC) {
            if (table[1][1] == firstC && table[1][2] == firstC) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //vertical3
        if (table[2][0] == firstC) {
            if (table[2][1] == firstC && table[2][2] == firstC) {
                scoreX++;
                scoreXText.setText(" " + scoreX);

                Toast.makeText(getApplicationContext(), "X wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //checking secondC
        //diagonal '\'
        if (table[0][0] == secondC) {
            if ((table[1][1] == secondC) && (table[2][2] == secondC)) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //diagonal
        if (table[2][0] == secondC) {
            if ((table[1][1] == secondC) && (table[0][2] == secondC)) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //horizontal wins from left to right
        //horizontal1
        if (table[0][0] == secondC) {
            if (table[1][0] == secondC && table[2][0] == secondC) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //horizontal2
        if (table[0][1] == secondC) {
            if (table[1][1] == secondC && table[2][1] == secondC) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //horizontal3
        if (table[0][2] == secondC) {
            if (table[1][2] == secondC && table[2][2] == secondC) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //vertical wins from up to down
        //vertical1
        if (table[0][0] == secondC) {
            if (table[0][1] == secondC && table[0][2] == secondC) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //vertical2
        if (table[1][0] == secondC) {
            if (table[1][1] == secondC && table[1][2] == secondC) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }
        //vertical3
        if (table[2][0] == secondC) {
            if (table[2][1] == secondC && table[2][2] == secondC) {
                scoreO++;
                scoreXText2.setText(" " + scoreO);

                Toast.makeText(getApplicationContext(), "O wins", Toast.LENGTH_LONG).show();
                disableAllButtons();
            }
        }


    }


    //disable the buttons when there is a win
    private void disableAllButtons() {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++) {
                    if (R.getChildAt(x) instanceof Button) {
                        Button B = (Button) R.getChildAt(x);
                        B.setEnabled(false);
                    }
                }
            }
        }
    }

    //enable the buttons when there is a win
    private void enableAllButtons() {
        TableLayout T = (TableLayout) findViewById(R.id.tableLayout);
        for (int y = 0; y < T.getChildCount(); y++) {
            if (T.getChildAt(y) instanceof TableRow) {
                TableRow R = (TableRow) T.getChildAt(y);
                for (int x = 0; x < R.getChildCount(); x++) {
                    if (R.getChildAt(x) instanceof Button) {
                        Button B = (Button) R.getChildAt(x);
                        B.setEnabled(true);
                    }
                }
            }
        }
    }

    //resets the game and including the scoreXboard
    public void reset(View view) {
        onRestart();
    }

    //restart method called the reset method
    @Override
    protected void onRestart() {
        this.recreate();
        super.onRestart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.choose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            //launches the VsComputer Activity
            case R.id.ai:
                startActivity(new Intent(getApplicationContext(), VsComputer.class));
                break;
            case R.id.two:
                Toast.makeText(TwoPlayers.this, "You're currently in the Activity", Toast.LENGTH_SHORT).show();
                break;        }
        return super.onOptionsItemSelected(item);
    }

}
