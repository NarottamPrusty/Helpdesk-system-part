# Helpdesk Ticketing System – Backend

A robust Helpdesk Ticketing backend application built with Java Spring Boot. It allows users to submit, track, and resolve IT/service-related tickets in an organization with clear role-based functionality.

---

## 📌 Project Overview

**Objective:**  
To manage and streamline internal support requests with an organized ticketing system. The system supports role-based access, ticket assignment, escalation, and resolution tracking.

---

## ✅ Features

- 🔐 **Authentication & Authorization**
  - JWT-based login system
  - Role-based access: `Admin`, `Support Agent`, `Employee`

- 🎫 **Ticket Management**
  - Create, view, update, delete tickets
  - Ticket status: Open, Assigned, Resolved, Closed
  - Priority levels: Low, Medium, High

- 👥 **User Management**
  - Admin can add/edit/remove users
  - Users can update their profiles

- 📊 **Dashboard & Reporting**
  - Ticket analytics by status and priority
  - Agent workload and performance

- 🛠️ **Support Functions**
  - Commenting on tickets
  - Attachments (optional)
  - Email notifications (if configured)

---

## ⚙️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Security
- **Database:** H2 (Dev) / MySQL or PostgreSQL (Prod)
- **Auth:** JWT (JSON Web Tokens)
- **Build Tool:** Maven
- **Documentation:** Swagger / OpenAPI

---

## 🚀 Getting Started

### 1. **Clone the Repository**
```bash
git clone https://github.com/yourusername/helpdesk-system.git
cd helpdesk-system
