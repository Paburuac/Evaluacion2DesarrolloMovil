package com.example.amigosycampanas.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.amigosycampanas.data.entities.Character;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CharacterDao_Impl implements CharacterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Character> __insertionAdapterOfCharacter;

  private final EntityDeletionOrUpdateAdapter<Character> __deletionAdapterOfCharacter;

  private final EntityDeletionOrUpdateAdapter<Character> __updateAdapterOfCharacter;

  public CharacterDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCharacter = new EntityInsertionAdapter<Character>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `characters` (`id`,`name`,`clazz`,`race`,`level`,`equipment`,`campaignId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Character entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getClazz() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getClazz());
        }
        if (entity.getRace() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getRace());
        }
        statement.bindLong(5, entity.getLevel());
        if (entity.getEquipment() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEquipment());
        }
        statement.bindLong(7, entity.getCampaignId());
      }
    };
    this.__deletionAdapterOfCharacter = new EntityDeletionOrUpdateAdapter<Character>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `characters` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Character entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCharacter = new EntityDeletionOrUpdateAdapter<Character>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `characters` SET `id` = ?,`name` = ?,`clazz` = ?,`race` = ?,`level` = ?,`equipment` = ?,`campaignId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Character entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getClazz() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getClazz());
        }
        if (entity.getRace() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getRace());
        }
        statement.bindLong(5, entity.getLevel());
        if (entity.getEquipment() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEquipment());
        }
        statement.bindLong(7, entity.getCampaignId());
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Character character, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCharacter.insertAndReturnId(character);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final Character[] characters,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCharacter.insert(characters);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Character character, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCharacter.handle(character);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Character character, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCharacter.handle(character);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getByCampaign(final long campaignId,
      final Continuation<? super List<Character>> $completion) {
    final String _sql = "SELECT * FROM characters WHERE campaignId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, campaignId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Character>>() {
      @Override
      @NonNull
      public List<Character> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClazz = CursorUtil.getColumnIndexOrThrow(_cursor, "clazz");
          final int _cursorIndexOfRace = CursorUtil.getColumnIndexOrThrow(_cursor, "race");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfEquipment = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment");
          final int _cursorIndexOfCampaignId = CursorUtil.getColumnIndexOrThrow(_cursor, "campaignId");
          final List<Character> _result = new ArrayList<Character>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Character _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpClazz;
            if (_cursor.isNull(_cursorIndexOfClazz)) {
              _tmpClazz = null;
            } else {
              _tmpClazz = _cursor.getString(_cursorIndexOfClazz);
            }
            final String _tmpRace;
            if (_cursor.isNull(_cursorIndexOfRace)) {
              _tmpRace = null;
            } else {
              _tmpRace = _cursor.getString(_cursorIndexOfRace);
            }
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final String _tmpEquipment;
            if (_cursor.isNull(_cursorIndexOfEquipment)) {
              _tmpEquipment = null;
            } else {
              _tmpEquipment = _cursor.getString(_cursorIndexOfEquipment);
            }
            final long _tmpCampaignId;
            _tmpCampaignId = _cursor.getLong(_cursorIndexOfCampaignId);
            _item = new Character(_tmpId,_tmpName,_tmpClazz,_tmpRace,_tmpLevel,_tmpEquipment,_tmpCampaignId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<Character>> $completion) {
    final String _sql = "SELECT * FROM characters ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Character>>() {
      @Override
      @NonNull
      public List<Character> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClazz = CursorUtil.getColumnIndexOrThrow(_cursor, "clazz");
          final int _cursorIndexOfRace = CursorUtil.getColumnIndexOrThrow(_cursor, "race");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfEquipment = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment");
          final int _cursorIndexOfCampaignId = CursorUtil.getColumnIndexOrThrow(_cursor, "campaignId");
          final List<Character> _result = new ArrayList<Character>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Character _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpClazz;
            if (_cursor.isNull(_cursorIndexOfClazz)) {
              _tmpClazz = null;
            } else {
              _tmpClazz = _cursor.getString(_cursorIndexOfClazz);
            }
            final String _tmpRace;
            if (_cursor.isNull(_cursorIndexOfRace)) {
              _tmpRace = null;
            } else {
              _tmpRace = _cursor.getString(_cursorIndexOfRace);
            }
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final String _tmpEquipment;
            if (_cursor.isNull(_cursorIndexOfEquipment)) {
              _tmpEquipment = null;
            } else {
              _tmpEquipment = _cursor.getString(_cursorIndexOfEquipment);
            }
            final long _tmpCampaignId;
            _tmpCampaignId = _cursor.getLong(_cursorIndexOfCampaignId);
            _item = new Character(_tmpId,_tmpName,_tmpClazz,_tmpRace,_tmpLevel,_tmpEquipment,_tmpCampaignId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getById(final long id, final Continuation<? super Character> $completion) {
    final String _sql = "SELECT * FROM characters WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Character>() {
      @Override
      @Nullable
      public Character call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClazz = CursorUtil.getColumnIndexOrThrow(_cursor, "clazz");
          final int _cursorIndexOfRace = CursorUtil.getColumnIndexOrThrow(_cursor, "race");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfEquipment = CursorUtil.getColumnIndexOrThrow(_cursor, "equipment");
          final int _cursorIndexOfCampaignId = CursorUtil.getColumnIndexOrThrow(_cursor, "campaignId");
          final Character _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpClazz;
            if (_cursor.isNull(_cursorIndexOfClazz)) {
              _tmpClazz = null;
            } else {
              _tmpClazz = _cursor.getString(_cursorIndexOfClazz);
            }
            final String _tmpRace;
            if (_cursor.isNull(_cursorIndexOfRace)) {
              _tmpRace = null;
            } else {
              _tmpRace = _cursor.getString(_cursorIndexOfRace);
            }
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final String _tmpEquipment;
            if (_cursor.isNull(_cursorIndexOfEquipment)) {
              _tmpEquipment = null;
            } else {
              _tmpEquipment = _cursor.getString(_cursorIndexOfEquipment);
            }
            final long _tmpCampaignId;
            _tmpCampaignId = _cursor.getLong(_cursorIndexOfCampaignId);
            _result = new Character(_tmpId,_tmpName,_tmpClazz,_tmpRace,_tmpLevel,_tmpEquipment,_tmpCampaignId);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object countByCampaign(final long campaignId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM characters WHERE campaignId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, campaignId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
