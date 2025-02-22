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

package bisq.core.payment.validation;

import bisq.core.util.validation.InputValidator;

public final class EmailOrMobileNrValidator extends InputValidator {

    private final EmailValidator emailValidator;

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Public methods
    ///////////////////////////////////////////////////////////////////////////////////////////

    public EmailOrMobileNrValidator() {
        emailValidator = new EmailValidator();
    }

    @Override
    public ValidationResult validate(String input) {
        ValidationResult result = validateIfNotEmpty(input);
        if (!result.isValid) {
            return result;
        } else {
            ValidationResult emailResult = emailValidator.validate(input);
            if (emailResult.isValid)
                return emailResult;
            else
                return validatePhoneNumber(input);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // Private methods
    ///////////////////////////////////////////////////////////////////////////////////////////

    // TODO not impl yet -> see InteracETransferValidator
    private ValidationResult validatePhoneNumber(String input) {
        return super.validate(input);
    }
}
