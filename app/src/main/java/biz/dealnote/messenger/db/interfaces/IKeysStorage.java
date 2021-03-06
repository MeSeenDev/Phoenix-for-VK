package biz.dealnote.messenger.db.interfaces;

import java.util.List;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import biz.dealnote.messenger.crypt.AesKeyPair;
import biz.dealnote.messenger.util.Optional;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by ruslan.kolbasa on 20.10.2016.
 * phoenix
 */
public interface IKeysStorage extends IStorage {
    @CheckResult
    Completable saveKeyPair(@NonNull AesKeyPair pair);

    @CheckResult
    Single<List<AesKeyPair>> getAll(int accountId);

    @CheckResult
    Single<List<AesKeyPair>> getKeys(int accountId, int peerId);

    @CheckResult
    Single<Optional<AesKeyPair>> findLastKeyPair(int accountId, int peerId);

    @CheckResult
    Maybe<AesKeyPair> findKeyPairFor(int accountId, long sessionId);

    @CheckResult
    Completable deleteAll(int accountId);
}
