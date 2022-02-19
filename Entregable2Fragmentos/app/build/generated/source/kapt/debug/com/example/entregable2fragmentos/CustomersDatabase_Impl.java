package com.example.entregable2fragmentos;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomersDatabase_Impl extends CustomersDatabase {
  private volatile CustomersDao _customersDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CustomersDatabase` (`mDatabase` TEXT, `mQueryExecutor` TEXT, `mTransactionExecutor` TEXT, `mOpenHelper` TEXT, `mInvalidationTracker` TEXT, `mAllowMainThreadQueries` INTEGER NOT NULL, `mWriteAheadLoggingEnabled` INTEGER NOT NULL, `mCallbacks` TEXT, `mAutoMigrationSpecs` TEXT NOT NULL, `mCloseLock` TEXT, `mAutoCloser` TEXT, `mSuspendingTransactionId` TEXT, `mBackingFieldMap` TEXT, `mTypeConverters` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'be42a38b6872233d568bcb279543ecb7')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `CustomersDatabase`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCustomersDatabase = new HashMap<String, TableInfo.Column>(14);
        _columnsCustomersDatabase.put("mDatabase", new TableInfo.Column("mDatabase", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mQueryExecutor", new TableInfo.Column("mQueryExecutor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mTransactionExecutor", new TableInfo.Column("mTransactionExecutor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mOpenHelper", new TableInfo.Column("mOpenHelper", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mInvalidationTracker", new TableInfo.Column("mInvalidationTracker", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mAllowMainThreadQueries", new TableInfo.Column("mAllowMainThreadQueries", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mWriteAheadLoggingEnabled", new TableInfo.Column("mWriteAheadLoggingEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mCallbacks", new TableInfo.Column("mCallbacks", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mAutoMigrationSpecs", new TableInfo.Column("mAutoMigrationSpecs", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mCloseLock", new TableInfo.Column("mCloseLock", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mAutoCloser", new TableInfo.Column("mAutoCloser", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mSuspendingTransactionId", new TableInfo.Column("mSuspendingTransactionId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mBackingFieldMap", new TableInfo.Column("mBackingFieldMap", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomersDatabase.put("mTypeConverters", new TableInfo.Column("mTypeConverters", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomersDatabase = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomersDatabase = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomersDatabase = new TableInfo("CustomersDatabase", _columnsCustomersDatabase, _foreignKeysCustomersDatabase, _indicesCustomersDatabase);
        final TableInfo _existingCustomersDatabase = TableInfo.read(_db, "CustomersDatabase");
        if (! _infoCustomersDatabase.equals(_existingCustomersDatabase)) {
          return new RoomOpenHelper.ValidationResult(false, "CustomersDatabase(com.example.entregable2fragmentos.CustomersDatabase).\n"
                  + " Expected:\n" + _infoCustomersDatabase + "\n"
                  + " Found:\n" + _existingCustomersDatabase);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "be42a38b6872233d568bcb279543ecb7", "4e1c17f8f043115f10a3f4d39d7bf7f9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "CustomersDatabase");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `CustomersDatabase`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CustomersDao.class, CustomersDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public CustomersDao CustomersDao() {
    if (_customersDao != null) {
      return _customersDao;
    } else {
      synchronized(this) {
        if(_customersDao == null) {
          _customersDao = new CustomersDao_Impl(this);
        }
        return _customersDao;
      }
    }
  }
}
