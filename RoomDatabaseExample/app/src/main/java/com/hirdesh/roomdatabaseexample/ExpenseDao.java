package com.hirdesh.roomdatabaseexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Query("Select * from expense")
    List<Expense> getAllExpense();

    @Insert
    void addTx(Expense expense);

    @Update
    void updateTx(Expense expense);

    @Delete
    void deleteTx(Expense expense);
}