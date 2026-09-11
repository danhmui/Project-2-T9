package com.javaweb.builder;

public class CustomerSearchBuilder {
    private String fullName;
    private String email;
    private String phone;
    private String status;
    private Long staffId;

    public Long getStaffId() {
        return staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    private CustomerSearchBuilder(Builder builder) {
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.status = builder.status;
        this.staffId = builder.staffId;
    }

    public static class Builder{
        private String fullName;
        private String email;
        private String phone;
        private String status;
        private Long staffId;

        public void setStaffId(Long staffId) {
            this.staffId = staffId;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public CustomerSearchBuilder build(){
            return new CustomerSearchBuilder(this);
        }
    }
}
