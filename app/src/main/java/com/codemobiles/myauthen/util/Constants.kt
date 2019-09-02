package com.codemobiles.myauthen.util



/**
 * Constants used throughout the app.
 */

// SQLite Database
const val DATABASE_NAME = "cm-db"

// Intent key
const val USER_BEAN = "USER_BEAN"

// Shared Preferences
const val PREFS_KEY_USERNAME = "username"
const val PREFS_KEY_PASSWORD = "password"

// Feed Server
const val FEED_TRAININGS = "training"
const val FEED_FOODS = "foods"
const val FEED_SUPERHEROS = "superhero"
const val FEED_SONGS = "songs"


/**
 *  consts are compile time constants.
 *  Meaning that their value has to be assigned during compile time.
 *
 *  unlike vals, where it can be done at runtime.
 *
 *  This means, that consts can never be assigned to a function
 *  or any class constructor, but only to a String or primitive.
 */