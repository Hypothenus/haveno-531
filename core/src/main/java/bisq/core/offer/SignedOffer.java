/*
 * This file is part of Haveno.
 *
 * Haveno is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Haveno is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Haveno. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.core.offer;

import java.util.List;

import bisq.common.proto.persistable.PersistablePayload;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode
@Slf4j
public final class SignedOffer implements PersistablePayload {
    
    @Getter
    private final long timeStamp;
    @Getter
    private final String offerId;
    @Getter
    private final String reserveTxHash;
    @Getter
    private final String reserveTxHex;
    @Getter
    private final List<String> reserveTxKeyImages;
    @Getter
    private final String arbitratorSignature;
    
    public SignedOffer(long timeStamp, String offerId, String reserveTxHash, String reserveTxHex, List<String> reserveTxKeyImages, String arbitratorSignature) {
        this.timeStamp = timeStamp;
        this.offerId = offerId;
        this.reserveTxHash = reserveTxHash;
        this.reserveTxHex = reserveTxHex;
        this.reserveTxKeyImages = reserveTxKeyImages;
        this.arbitratorSignature = arbitratorSignature;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // PROTO BUFFER
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public protobuf.SignedOffer toProtoMessage() {
        protobuf.SignedOffer.Builder builder = protobuf.SignedOffer.newBuilder()
                .setTimeStamp(timeStamp)
                .setOfferId(offerId)
                .setReserveTxHash(reserveTxHash)
                .setReserveTxHex(reserveTxHex)
                .addAllReserveTxKeyImages(reserveTxKeyImages)
                .setArbitratorSignature(arbitratorSignature);
        return builder.build();
    }

    public static SignedOffer fromProto(protobuf.SignedOffer proto) {
        return new SignedOffer(proto.getTimeStamp(), proto.getOfferId(), proto.getReserveTxHash(), proto.getReserveTxHex(), proto.getReserveTxKeyImagesList(), proto.getArbitratorSignature());
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return "SignedOffer{" +
                ",\n     timeStamp=" + timeStamp +
                ",\n     offerId=" + offerId +
                ",\n     reserveTxHash=" + reserveTxHash +
                ",\n     reserveTxHex=" + reserveTxHex +
                ",\n     reserveTxKeyImages=" + reserveTxKeyImages +
                ",\n     arbitratorSignature=" + arbitratorSignature +
                "\n}";
    }
}

