package com.example.house.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OwnerNameConverter implements AttributeConverter<OwnerName, String> {

    @Override
    public String convertToDatabaseColumn(OwnerName ownerName) {
        if (ownerName == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        if (ownerName.getLastName() != null && !ownerName.getLastName().isEmpty()) {
            sb.append(ownerName.getLastName());
        }
        if (ownerName.getFirstName() != null && !ownerName.getFirstName().isEmpty()) {
            sb.append(" ").append(ownerName.getFirstName());
        }

        return sb.toString();
    }

    @Override
    public OwnerName convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }

        OwnerName ownerName = new OwnerName();

        String[] tokens = s.split(" ");
        if (tokens.length == 1) {
            if (tokens[0].charAt(0) == ' ') {
                ownerName.setFirstName(tokens[0]);
                ownerName.setLastName(null);
            } else {
                ownerName.setFirstName(null);
                ownerName.setLastName(tokens[0]);
            }
        } else {
            ownerName.setFirstName(tokens[1]);
            ownerName.setLastName(tokens[0]);
        }

        return ownerName;
    }
}
