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

package bisq.desktop.main.offer.createoffer;

import bisq.desktop.Navigation;
import bisq.desktop.common.model.ViewModel;
import bisq.desktop.main.offer.MutableOfferViewModel;
import bisq.core.account.witness.AccountAgeWitnessService;
import bisq.core.offer.OfferUtil;
import bisq.core.payment.validation.BtcValidator;
import bisq.core.payment.validation.FiatVolumeValidator;
import bisq.core.payment.validation.SecurityDepositValidator;
import bisq.core.provider.price.PriceFeedService;
import bisq.core.user.Preferences;
import bisq.core.util.FormattingUtils;
import bisq.core.util.coin.CoinFormatter;
import bisq.core.util.validation.AltcoinValidator;
import bisq.core.util.validation.FiatPriceValidator;
import com.google.inject.Inject;

import javax.inject.Named;

class CreateOfferViewModel extends MutableOfferViewModel<CreateOfferDataModel> implements ViewModel {

    @Inject
    public CreateOfferViewModel(CreateOfferDataModel dataModel,
                                FiatVolumeValidator fiatVolumeValidator,
                                FiatPriceValidator fiatPriceValidator,
                                AltcoinValidator altcoinValidator,
                                BtcValidator btcValidator,
                                SecurityDepositValidator securityDepositValidator,
                                PriceFeedService priceFeedService,
                                AccountAgeWitnessService accountAgeWitnessService,
                                Navigation navigation,
                                Preferences preferences,
                                @Named(FormattingUtils.BTC_FORMATTER_KEY) CoinFormatter btcFormatter,
                                OfferUtil offerUtil) {
        super(dataModel,
                fiatVolumeValidator,
                fiatPriceValidator,
                altcoinValidator,
                btcValidator,
                securityDepositValidator,
                priceFeedService,
                accountAgeWitnessService,
                navigation,
                preferences,
                btcFormatter,
                offerUtil);
    }
}
