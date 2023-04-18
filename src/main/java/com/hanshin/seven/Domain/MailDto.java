package com.hanshin.seven.Domain;

public class MailDto {
   private String address;
   private String title;
   private String message;
   
   public MailDto() {
      super();
   }
   
   public MailDto(String address, String title, String message) {
      super();
      this.address = address;
      this.title = title;
      this.message = message;
   }
   
   @Override
   public String toString() {
      return "MailDto [address=" + address + ", title=" + title + ", message=" + message + "]";
   }
   
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   
   public String getMessage() {
      return message;
   }
   public void setMessage(String message) {
      this.message = message;
   }
}