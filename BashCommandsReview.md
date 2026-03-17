# Bash Commands Review

## File & Directory Operations

### Navigation
```bash
pwd                    # Print working directory
cd /path/to/directory  # Change directory
cd ..                  # Go up one directory
cd ~                   # Go to home directory
cd -                   # Go to previous directory
ls                     # List files
ls -la                 # List all files with details
ls -lh                 # List with human-readable sizes
```

### File Operations
```bash
touch filename.txt     # Create empty file
cp source dest         # Copy file
cp -r source_dir dest_dir  # Copy directory
mv old_name new_name   # Move/rename file
rm filename            # Remove file
rm -r directory        # Remove directory and contents
rm -f file             # Force remove (no prompt)
mkdir new_directory    # Create directory
mkdir -p path/to/dir   # Create nested directories
```

### File Content
```bash
cat filename           # Display file content
less filename          # View file (scrollable)
more filename          # View file (simple)
head filename          # Show first 10 lines
tail filename          # Show last 10 lines
tail -f filename       # Follow file (live updates)
wc filename            # Count lines/words/characters
```

## Text Processing

### Search & Filter
```bash
grep "pattern" file    # Search for pattern
grep -i "pattern" file # Case-insensitive search
grep -r "pattern" dir  # Recursive search
grep -n "pattern" file # Show line numbers
find . -name "*.txt"   # Find files by name
find . -type f         # Find all files
```

### Text Manipulation
```bash
sed 's/old/new/g' file    # Replace text
awk '{print $1}' file      # Print first column
sort file                 # Sort lines
uniq file                 # Remove duplicates
cut -d',' -f1 file        # Extract columns
paste file1 file2          # Merge files
```

## System Information

### System Status
```bash
top                      # Show running processes
htop                     # Enhanced top (if installed)
ps aux                   # Show all processes
ps aux | grep process    # Find specific process
kill PID                 # Kill process by ID
killall process_name     # Kill process by name
```

### System Info
```bash
uname -a                 # System information
df -h                    # Disk usage (human-readable)
du -sh directory         # Directory size
free -h                  # Memory usage
uptime                   # System uptime
whoami                   # Current user
id                       # User ID and groups
```

## Network Commands

### Basic Network
```bash
ping google.com          # Test connectivity
ping -c 4 google.com     # Ping 4 times only
ip addr                  # Show IP addresses
ifconfig                 # Show network interfaces (older)
netstat -tulnp          # Show network connections
ss -tulnp               # Modern netstat
```

### File Transfer
```bash
scp file user@host:/path # Secure copy
rsync -av src dest       # Sync directories
wget url                 # Download file
curl -O url              # Download file with same name
```

## Permissions & Ownership

### File Permissions
```bash
chmod 755 file           # Set permissions
chmod +x script.sh       # Make executable
chmod -w file            # Remove write permission
chown user:group file    # Change owner and group
sudo chown -R user dir   # Recursively change ownership
```

### Permission Numbers
```bash
# Read = 4, Write = 2, Execute = 1
# 755 = rwxr-xr-x (owner: rwx, group: rx, others: rx)
# 644 = rw-r--r-- (owner: rw, group: r, others: r)
# 777 = rwxrwxrwx (everyone: rwx)
```

## Archiving & Compression

### Tar Commands
```bash
tar -czf archive.tar.gz dir/    # Create tar.gz
tar -xzf archive.tar.gz         # Extract tar.gz
tar -tzf archive.tar.gz         # List contents
tar -cjf archive.tar.bz2 dir/   # Create tar.bz2
```

### Other Formats
```bash
zip -r archive.zip dir/         # Create zip
unzip archive.zip                # Extract zip
gzip file                        # Compress single file
gunzip file.gz                   # Decompress
```

## Environment & Variables

### Environment Variables
```bash
env                      # List all variables
echo $PATH              # Show PATH variable
export VAR=value         # Set variable
export PATH=$PATH:/new/path  # Add to PATH
source ~/.bashrc         # Reload bash configuration
```

### Aliases
```bash
alias                    # Show all aliases
alias ll='ls -la'        # Create alias
unalias ll               # Remove alias
```

## History & Shortcuts

### Command History
```bash
history                  # Show command history
history | grep command   # Search history
!!                       # Repeat last command
!n                       # Repeat command number n
!grep                    # Repeat last grep command
Ctrl + r                 # Reverse search history
```

### Bash Shortcuts
```bash
Ctrl + a                 # Beginning of line
Ctrl + e                 # End of line
Ctrl + u                 # Delete to beginning
Ctrl + k                 # Delete to end
Ctrl + w                 # Delete word
Ctrl + c                 # Cancel command
Ctrl + d                 # Exit shell
Tab                      # Auto-complete
```

## Process Management

### Background Jobs
```bash
command &                # Run in background
jobs                     # Show background jobs
fg %1                    # Bring job 1 to foreground
bg %1                    # Resume job 1 in background
kill %1                  # Kill background job
nohup command &          # Run after logout
```

### System Services
```bash
systemctl status service    # Check service status
systemctl start service     # Start service
systemctl stop service      # Stop service
systemctl restart service   # Restart service
systemctl enable service    # Enable on boot
```

## Disk & Storage

### Disk Management
```bash
lsblk                     # List block devices
mount                     # Show mounted filesystems
mount /dev/sdb1 /mnt     # Mount device
umount /mnt              # Unmount device
fdisk -l                 # List disk partitions
```

### Cleanup
```bash
df -h                    # Check disk space
du -sh *                 # Check directory sizes
find . -type f -size +100M  # Find large files
```

## Git Commands (Bonus)

### Basic Git
```bash
git init                 # Initialize repository
git status               # Show status
git add .                # Stage all changes
git commit -m "message"  # Commit changes
git push                 # Push to remote
git pull                 # Pull from remote
git log                  # Show commit history
```

## Useful One-Liners

### System Monitoring
```bash
watch -n 1 'df -h'                   # Watch disk usage every second
ps aux --sort=-%mem | head            # Show processes by memory usage
find . -name "*.log" -exec rm {} \;  # Delete all log files
```

### File Operations
```bash
find . -type f -exec grep "pattern" {} \;  # Search all files
tar -czf backup.tar.gz --exclude='*.tmp' .  # Backup excluding temp files
```

## Troubleshooting

### Common Issues
```bash
chmod +x script.sh       # Make script executable
sudo !!                  # Run last command with sudo
which command            # Find command location
type command             # Show command type
```

### Debugging
```bash
bash -x script.sh        # Debug script execution
strace command           # Trace system calls
lsof -i :8080           # Show processes using port 8080
```

## Quick Reference Card

### Essential Commands
```bash
ls, cd, pwd, mkdir, rm, cp, mv  # File operations
grep, find, sed, awk              # Text processing
ps, kill, top, htop               # Process management
chmod, chown                       # Permissions
tar, zip, unzip                   # Archiving
ping, ip, netstat                  # Network
```

### Must-Know Shortcuts
```bash
Tab           # Auto-complete
Ctrl + c      # Cancel
Ctrl + r      # Search history
!!            # Last command
!$            # Last argument
```

## Safety Tips

### Before Running Destructive Commands
```bash
# Always test with -n (dry run) first
rm -rf directory          # DANGEROUS - double-check path
rm -rf /                  # NEVER DO THIS - wipes system
chmod -R 777 /            # NEVER DO THIS - security risk
```

### Best Practices
```bash
# Use quotes for paths with spaces
cp "file with spaces.txt" /dest/

# Test commands before running on important data
# Use backup before major operations
# Read man pages: man command
```
