package com.example.client.Classes;

import com.example.client.Entities.EventParticipant;

import java.util.HashMap;
import java.util.UUID;

public class EventParticipantHandler {
    GetEventParticipantsCallback getEventParticipantsCallback;
    public interface GetEventParticipantsCallback{
        void onEventParticipantsFetched(boolean success, HashMap<UUID, EventParticipant> comments);
    }

    public void setNotifyFetchedEventParticipants(GetEventParticipantsCallback callback) {
        this.getEventParticipantsCallback= callback;
    }

    public void notifyEventParticipantsFetched(boolean success, HashMap<UUID, EventParticipant> participants){
        if(getEventParticipantsCallback != null){
            getEventParticipantsCallback.onEventParticipantsFetched(success, participants);
        }
    }


    UpdateEventEventParticipantStatus updateEventEventParticipantStatus;
    public interface UpdateEventEventParticipantStatus{
        void onEventParticipantStatusUpdate(boolean success);
    }

    public void setNotifyUpdatedEventParticipantStatus(UpdateEventEventParticipantStatus callback) {
        this.updateEventEventParticipantStatus = callback;
    }

    public void notifyEventParticipantStatusUpdated(boolean success){
        if(updateEventEventParticipantStatus != null){
            updateEventEventParticipantStatus.onEventParticipantStatusUpdate(success);
        }
    }
}
