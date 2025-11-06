package com.example.amigosycampanas.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.amigosycampanas.data.entities.Campaign;
import com.example.amigosycampanas.data.entities.CampaignWithCharacters;
import com.example.amigosycampanas.data.entities.Character;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
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
public final class CampaignDao_Impl implements CampaignDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Campaign> __insertionAdapterOfCampaign;

  private final EntityDeletionOrUpdateAdapter<Campaign> __deletionAdapterOfCampaign;

  private final EntityDeletionOrUpdateAdapter<Campaign> __updateAdapterOfCampaign;

  public CampaignDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCampaign = new EntityInsertionAdapter<Campaign>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `campaigns` (`id`,`name`,`city`,`isDiscord`,`latitude`,`longitude`,`description`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Campaign entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCity() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCity());
        }
        final int _tmp = entity.isDiscord() ? 1 : 0;
        statement.bindLong(4, _tmp);
        if (entity.getLatitude() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getLatitude());
        }
        if (entity.getLongitude() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getLongitude());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDescription());
        }
      }
    };
    this.__deletionAdapterOfCampaign = new EntityDeletionOrUpdateAdapter<Campaign>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `campaigns` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Campaign entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCampaign = new EntityDeletionOrUpdateAdapter<Campaign>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `campaigns` SET `id` = ?,`name` = ?,`city` = ?,`isDiscord` = ?,`latitude` = ?,`longitude` = ?,`description` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Campaign entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCity() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCity());
        }
        final int _tmp = entity.isDiscord() ? 1 : 0;
        statement.bindLong(4, _tmp);
        if (entity.getLatitude() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getLatitude());
        }
        if (entity.getLongitude() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getLongitude());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDescription());
        }
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Campaign campaign, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCampaign.insertAndReturnId(campaign);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Campaign campaign, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCampaign.handle(campaign);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Campaign campaign, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCampaign.handle(campaign);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<Campaign>> $completion) {
    final String _sql = "SELECT * FROM campaigns ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Campaign>>() {
      @Override
      @NonNull
      public List<Campaign> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfIsDiscord = CursorUtil.getColumnIndexOrThrow(_cursor, "isDiscord");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<Campaign> _result = new ArrayList<Campaign>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Campaign _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final boolean _tmpIsDiscord;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDiscord);
            _tmpIsDiscord = _tmp != 0;
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item = new Campaign(_tmpId,_tmpName,_tmpCity,_tmpIsDiscord,_tmpLatitude,_tmpLongitude,_tmpDescription);
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
  public Object getById(final long id, final Continuation<? super Campaign> $completion) {
    final String _sql = "SELECT * FROM campaigns WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Campaign>() {
      @Override
      @Nullable
      public Campaign call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfIsDiscord = CursorUtil.getColumnIndexOrThrow(_cursor, "isDiscord");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final Campaign _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCity;
            if (_cursor.isNull(_cursorIndexOfCity)) {
              _tmpCity = null;
            } else {
              _tmpCity = _cursor.getString(_cursorIndexOfCity);
            }
            final boolean _tmpIsDiscord;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsDiscord);
            _tmpIsDiscord = _tmp != 0;
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _result = new Campaign(_tmpId,_tmpName,_tmpCity,_tmpIsDiscord,_tmpLatitude,_tmpLongitude,_tmpDescription);
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
  public Object getWithCharacters(final long campaignId,
      final Continuation<? super List<CampaignWithCharacters>> $completion) {
    final String _sql = "SELECT * FROM campaigns WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, campaignId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<List<CampaignWithCharacters>>() {
      @Override
      @NonNull
      public List<CampaignWithCharacters> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
            final int _cursorIndexOfIsDiscord = CursorUtil.getColumnIndexOrThrow(_cursor, "isDiscord");
            final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
            final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
            final LongSparseArray<ArrayList<Character>> _collectionCharacters = new LongSparseArray<ArrayList<Character>>();
            while (_cursor.moveToNext()) {
              final long _tmpKey;
              _tmpKey = _cursor.getLong(_cursorIndexOfId);
              if (!_collectionCharacters.containsKey(_tmpKey)) {
                _collectionCharacters.put(_tmpKey, new ArrayList<Character>());
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipcharactersAscomExampleAmigosycampanasDataEntitiesCharacter(_collectionCharacters);
            final List<CampaignWithCharacters> _result = new ArrayList<CampaignWithCharacters>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final CampaignWithCharacters _item;
              final Campaign _tmpCampaign;
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final String _tmpName;
              if (_cursor.isNull(_cursorIndexOfName)) {
                _tmpName = null;
              } else {
                _tmpName = _cursor.getString(_cursorIndexOfName);
              }
              final String _tmpCity;
              if (_cursor.isNull(_cursorIndexOfCity)) {
                _tmpCity = null;
              } else {
                _tmpCity = _cursor.getString(_cursorIndexOfCity);
              }
              final boolean _tmpIsDiscord;
              final int _tmp;
              _tmp = _cursor.getInt(_cursorIndexOfIsDiscord);
              _tmpIsDiscord = _tmp != 0;
              final Double _tmpLatitude;
              if (_cursor.isNull(_cursorIndexOfLatitude)) {
                _tmpLatitude = null;
              } else {
                _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
              }
              final Double _tmpLongitude;
              if (_cursor.isNull(_cursorIndexOfLongitude)) {
                _tmpLongitude = null;
              } else {
                _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
              }
              final String _tmpDescription;
              if (_cursor.isNull(_cursorIndexOfDescription)) {
                _tmpDescription = null;
              } else {
                _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
              }
              _tmpCampaign = new Campaign(_tmpId,_tmpName,_tmpCity,_tmpIsDiscord,_tmpLatitude,_tmpLongitude,_tmpDescription);
              final ArrayList<Character> _tmpCharactersCollection;
              final long _tmpKey_1;
              _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpCharactersCollection = _collectionCharacters.get(_tmpKey_1);
              _item = new CampaignWithCharacters(_tmpCampaign,_tmpCharactersCollection);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipcharactersAscomExampleAmigosycampanasDataEntitiesCharacter(
      @NonNull final LongSparseArray<ArrayList<Character>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchLongSparseArray(_map, true, (map) -> {
        __fetchRelationshipcharactersAscomExampleAmigosycampanasDataEntitiesCharacter(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`name`,`clazz`,`race`,`level`,`equipment`,`campaignId` FROM `characters` WHERE `campaignId` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      final long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "campaignId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfName = 1;
      final int _cursorIndexOfClazz = 2;
      final int _cursorIndexOfRace = 3;
      final int _cursorIndexOfLevel = 4;
      final int _cursorIndexOfEquipment = 5;
      final int _cursorIndexOfCampaignId = 6;
      while (_cursor.moveToNext()) {
        final long _tmpKey;
        _tmpKey = _cursor.getLong(_itemKeyIndex);
        final ArrayList<Character> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final Character _item_1;
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
          _item_1 = new Character(_tmpId,_tmpName,_tmpClazz,_tmpRace,_tmpLevel,_tmpEquipment,_tmpCampaignId);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
