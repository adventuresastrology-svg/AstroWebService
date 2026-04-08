<!-- SQUARESPACE LESSON EMBEDDING GUIDE -->

# How to Add Lessons to Squarespace

## Quick Copy-Paste Instructions (5 Steps)

### Step 1: Open Squarespace Editor
- Go to your Squarespace website
- Click **Pages** in the left menu
- Click on the page where you want the lesson
- Click **Edit** (pencil icon)

### Step 2: Add a Code Block
- Find where you want the lesson on the page
- Click the **+** button (add block)
- Search for **"Code"**
- Click **Code Block**

### Step 3: Copy the Lesson Code
- Open this file: `squarespace-lesson-1-1.html` (or 1-2)
- Select ALL the code (Ctrl+A or Cmd+A)
- Copy it (Ctrl+C or Cmd+C)

### Step 4: Paste Into Squarespace
- Click inside the Code Block
- Paste (Ctrl+V or Cmd+V)
- The lesson preview appears instantly

### Step 5: Publish
- Click **Save** (top right)
- Click **Publish** (or **Update** if already published)
- Done! Your lesson is live

---

## Which Files to Use

| File | Purpose |
|------|---------|
| `squarespace-lesson-1-1.html` | Lesson 1.1 - Intro to Transits |
| `squarespace-lesson-1-2.html` | Lesson 1.2 - Practical Transit Work |

**Use ONLY the squarespace versions** (they're optimized for embedded code blocks)

---

## Before You Paste (Important!)

✓ Make sure the Code Block is EMPTY (no existing text)
✓ Clear any placeholder text first
✓ Don't add extra line breaks before/after the code

---

## After You Paste

**What you should see:**
- Beige/tan colored lesson box
- Title in large text
- Sections with gray headers
- Light boxes with accent borders
- Footer with "Next Lesson" info

**If it looks broken:**
1. Try refreshing the page (F5)
2. Make sure you copied the ENTIRE code (all 300+ lines)
3. Check that no text was accidentally deleted

---

## Mobile Preview

The lessons automatically adapt to phones and tablets. Test by:
- Saving the lesson
- Viewing your site on a phone
- Everything should stack nicely (no horizontal scrolling)

---

## Color Guide (If You Want to Customize)

The colors are defined at the top of the code. Find these lines and change them:

```
background: #faf9f7;     /* Light cream background */
color: #a87c3f;          /* Brown accent color */
color: #9b8f81;          /* Muted brown text */
color: #1a1815;          /* Dark brown text */
```

---

## Troubleshooting

**Problem: Code appears as text, not formatted lesson**
- Solution: You're in the wrong editor mode. Make sure you're in HTML/Code Block view, not rich text.

**Problem: Colors look wrong**
- Solution: Squarespace might be overriding colors. Add `!important` to color values:
  - Change `color: #a87c3f;` to `color: #a87c3f !important;`

**Problem: Text is too small/too big**
- Solution: The lesson scales automatically. If text is tiny, try refreshing or clearing browser cache.

**Problem: Spacing looks off**
- Solution: Make sure no extra content is outside the lesson div. The code is self-contained.

---

## Adding Multiple Lessons

Want Lesson 1.1 AND 1.2 on the same page?
1. Add first Code Block with `squarespace-lesson-1-1.html`
2. Add second Code Block right below
3. Paste `squarespace-lesson-1-2.html`

They'll stack nicely with proper spacing.

---

## Support Note

These lessons are designed to work in Squarespace Code Blocks without modification. If you need to add them to:
- **Blog post:** Use Code Block in blog editor (same steps)
- **Custom page template:** Paste into HTML injector
- **Footer:** Use Footer Code Injection (paste without `<style>` tags)

---

**Ready to go!** Pick a lesson file and follow the 5 steps above. ✓
