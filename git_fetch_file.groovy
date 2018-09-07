#!/usr/bin/env groovy

def call(args) {
    def url = args.get('url', '')
    def creds_id = args.get('creds_id', '')
    def branch = args.get('branch', 'master')
    def path = args.get('path', '')
    def filename = args.get('filename', '')
    def stashname = args.get('stashname', 'git_fetch_file_stash')

    del_regex = ~/^(origin|refs\/tags)\//
    branch = branch - del_regex

    dir('tmp_git_fetch_file'){
        sshagent(credentials: [ repo_creds ]) {
            sh "git archive --remote=${url} --prefix ${path} ${branch}:${path} | tar xvf - --xform='s#^.+/##x'"
            stash includes: filename, name: stashname
        }
        deleteDir()
    }
}

return this;
