package org.simpleaas.contactinformation.contactinformation1_0.ipcommunication;

import java.util.Optional;

public enum TypeOfCommunication {
    Chat("Chat"),
    VideoCall("Video call");

    private final String type;

    TypeOfCommunication(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.type;
    }

    public static Optional<TypeOfCommunication> createFromValue(String communicationValue) {

        switch (communicationValue) {
            case "Chat" -> {
                return Optional.of(TypeOfCommunication.Chat);
            }
            case "Video call" -> {
                return Optional.of(TypeOfCommunication.VideoCall);
            }
            default -> {
             return Optional.empty();
            }
        }
    }
}
