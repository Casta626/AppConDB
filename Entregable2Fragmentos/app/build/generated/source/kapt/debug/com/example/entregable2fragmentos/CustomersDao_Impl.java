package com.example.entregable2fragmentos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.android.trackmysleepquality.database.Customers;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomersDao_Impl implements CustomersDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Customers> __insertionAdapterOfCustomers;

  private final SharedSQLiteStatement __preparedStmtOfDelAll;

  public CustomersDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomers = new EntityInsertionAdapter<Customers>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `customers` (`dni`,`nombre`,`apellidos`,`telefono`,`correo`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customers value) {
        if (value.getDni() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDni());
        }
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getApellidos() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApellidos());
        }
        if (value.getTelefono() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTelefono());
        }
        if (value.getCorreo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCorreo());
        }
      }
    };
    this.__preparedStmtOfDelAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM customers";
        return _query;
      }
    };
  }

  @Override
  public Object insertAll(final List<Customers> record,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCustomers.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDelAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<Customers>> continuation) {
    final String _sql = "SELECT * FROM customers";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Customers>>() {
      @Override
      public List<Customers> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
