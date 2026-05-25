# Test Cases - Foodie Ordering App

Detailed test cases with expected results.

## TC_01: User Registration
**Pre-condition**: User is on the Register page.

| Step | Action | Expected Result |
|------|--------|-----------------|
| 1 | Enter valid Name, Email, Password | Data accepted |
| 2 | Enter mismatching Confirm Password | Error message "Passwords do not match" appears |
| 3 | Click Register with valid data | Success alert shown, redirected to Login |

## TC_02: User Login
**Pre-condition**: User is registered.

| Step | Action | Expected Result |
|------|--------|-----------------|
| 1 | Enter invalid credentials | Error message displayed |
| 2 | Enter valid email and password | Redirected to Menu page |
| 3 | Verify "Hi, [Name]" in Navbar | Name correctly displayed |

## TC_03: Cart Management
**Pre-condition**: User is logged in.

| Step | Action | Expected Result |
|------|--------|-----------------|
| 1 | Click "Add to Cart" on Cheese Burger | Alert "Cheese Burger added" shown, Cart count updates to (1) |
| 2 | Navigate to Cart page | Cheese Burger listed with price $12.99 |
| 3 | Click "Remove" | Item removed, Cart total updates |

## TC_04: Checkout Process
**Pre-condition**: Items in cart.

| Step | Action | Expected Result |
|------|--------|-----------------|
| 1 | Click "Proceed to Checkout" | Redirected to Checkout page |
| 2 | Leave fields empty and submit | Alert "Please fill in all checkout fields" shown |
| 3 | Fill all fields and submit | "Order Successful!" message displayed, Cart cleared |
