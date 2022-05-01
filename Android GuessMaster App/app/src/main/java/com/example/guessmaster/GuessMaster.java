package com.example.guessmaster;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GuessMaster extends AppCompatActivity {
    //Objects
    private TextView entityName;
    private TextView ticketsum;
    private Button guessButton;
    private EditText userIn;
    private Button btnclearContent;
    private ImageView entityImage;

    //Variables
    private int numOfEntities;
    private Entity[] entities;
    private Entity Global_Entity;
    private int totalTicketNum = 0;

    //Creates the four entities
    com.example.guessmaster.Politician jTrudeau = new com.example.guessmaster.Politician("Justin Trudeau", new com.example.guessmaster.Date("December", 25, 1971), "Male", "Liberal", 0.25);////
    com.example.guessmaster.Singer cDion = new com.example.guessmaster.Singer("Celine Dion", new com.example.guessmaster.Date("March", 30, 1961), "Female", "La voix du bon Dieu", new com.example.guessmaster.Date("November", 6, 1981), 0.5);////
    com.example.guessmaster.Person myCreator = new com.example.guessmaster.Person("My Creator", new com.example.guessmaster.Date("September", 1, 2000), "Female", 1);////
    com.example.guessmaster.Country usa = new com.example.guessmaster.Country("United States", new com.example.guessmaster.Date("July", 4, 1776), "Washington D.C.", 0.1);////

    // sorry this makes app crash, took me a day to figure it out
    // final GuessMaster gm = new GuessMaster();

    public GuessMaster() {
        numOfEntities = 0;
        entities = new Entity[10];
    }

    public void addEntity(Entity entity) {
        entities[numOfEntities++] = entity.clone();
    }

    public void playGame(int entityId) {
        Entity entity = entities[entityId];
        playGame(entity);
    }

    public void playGame(Entity entity) {
        entityName.setText(entity.getName());
        //Get Input from the EdiText
        String answer = userIn.getText().toString();
        answer = answer.replace("\n", "").replace("\r", "");
        Date date = new Date(answer);

        if (date.precedes(entity.getBorn())) {
            //Incorrect. Try a later date.
            AlertDialog.Builder laterDateAlert = new AlertDialog.Builder(GuessMaster.this);
            laterDateAlert.setTitle("Incorrect");
            laterDateAlert.setMessage("Try a later date than " + date.toString());
            laterDateAlert.setCancelable(false);
            laterDateAlert.setIcon(R.drawable.ic_error_outline_black_24dp);
            laterDateAlert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            laterDateAlert.show();

        } else if (entity.getBorn().precedes(date)) {
            //Incorrect. Try an earlier date.
            AlertDialog.Builder EarlyDateAlert = new AlertDialog.Builder(GuessMaster.this);
            EarlyDateAlert.setTitle("Incorrect");
            EarlyDateAlert.setMessage("Try an earlier date than " + date.toString());
            EarlyDateAlert.setCancelable(false);
            EarlyDateAlert.setIcon(R.drawable.ic_error_outline_black_24dp);
            EarlyDateAlert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            EarlyDateAlert.show();

        } else {
            //increase ticket count :)
            totalTicketNum += entity.getAwardedTicketNumber();
            ticketsum.setText("Total Tickets = " + String.valueOf(totalTicketNum));
            //correct guess message
            AlertDialog.Builder correctalert = new AlertDialog.Builder(GuessMaster.this);
            correctalert.setTitle("You Won!");
            correctalert.setMessage("Bingo! " + entity.closingMessage());
            correctalert.setIcon(R.drawable.ic_check_circle_black_24dp);
            correctalert.setCancelable(false);
            correctalert.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    Toast.makeText(getBaseContext(), "You won " + entity.getAwardedTicketNumber() + " tickets!", Toast.LENGTH_SHORT).show();
                }
            });
            correctalert.show();
            ticketsum.setText("Total Tickets: " + totalTicketNum);
            //after correct answer, picks next entity
            changeEntity();
        }


    }

    public void playGame() {
        int entityId = genRandomEntityId();
        playGame(entityId);
    }

    //picks pseudo-random entity
    public int genRandomEntityId() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(numOfEntities);
    }

    //Changes the entity to guess
    public void changeEntity() {
        Global_Entity = entities[genRandomEntityId()];
        //to set the image
        ImageSetter(Global_Entity);

        entityName.setText(Global_Entity.getName());
        //Clear Previous Entry
        userIn.getText().clear();
    }

    //Welcome Alert
    public void welcomeToGame(Entity entity) {
        AlertDialog.Builder welcomealert = new AlertDialog.Builder(GuessMaster.this);
        welcomealert.setTitle("GuessMaster Game v3");
        welcomealert.setMessage(entity.welcomeMessage());
        welcomealert.setCancelable(false);
        welcomealert.setNegativeButton("START GAME", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Game is Starting...", Toast.LENGTH_SHORT).show();
            }
        });
        //Show Dialog
        welcomealert.show();
    }

    //method to set the Image for each entity
    public void ImageSetter(Entity entImg) {

        if (entImg.toString().equals(jTrudeau.toString())) {
            entityImage.setImageResource(R.drawable.justint);
        } else if (entImg.toString().equals(cDion.toString())) {
            entityImage.setImageResource(R.drawable.celidion);
        } else if (entImg.toString().equals(myCreator.toString())) {
            entityImage.setImageResource(R.drawable.mycreator);
        } else {
            entityImage.setImageResource(R.drawable.usaflag);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the xml as the activity UI view
        setContentView(R.layout.activity_main);
        //Specify the button in the view
        guessButton = (Button) findViewById((R.id.btnGuess));

        //EditText for user input
        userIn = (EditText) findViewById(R.id.guessinput);
        //TextView for total tickets
        ticketsum = (TextView) findViewById(R.id.ticket);

        guessButton = (Button) findViewById(R.id.btnGuess);
        btnclearContent = (Button) findViewById(R.id.btnClear);
        entityName = (TextView) findViewById(R.id.entityName);
        entityImage = (ImageView) findViewById(R.id.entityImage);

        //Adds the four entity
        addEntity(jTrudeau);
        addEntity(cDion);
        addEntity(myCreator);
        addEntity(usa);

        changeEntity();
        //Welcome game pop-up
        welcomeToGame(Global_Entity);

        //OnClick Listener action for clear button
        btnclearContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEntity();
            }
        });

        //OnClick Listener action for submit button
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //playing game
                playGame(Global_Entity);
            }
        });

    }
}